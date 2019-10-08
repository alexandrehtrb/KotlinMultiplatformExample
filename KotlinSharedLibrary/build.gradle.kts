import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
    id("com.vanniktech.android.junit.jacoco")
}

//TODO: Separate configs in multiple Gradle KTS files

//region JaCoCo config

val filesToExclude = listOf("**/*Interfaces*.*", "**/*BuildConfig*.*", "**/*Creator*.*")

junitJacoco {
    jacocoVersion = Plugins.jacocoVersion // type String
    setIgnoreProjects("") // type String array
    excludes = filesToExclude // type String List
    includeNoLocationClasses = true // type boolean
    includeInstrumentationCoverageInMergedReport = false // type boolean
}

//endregion

//region Android config

android {
    compileSdkVersion(AppVersions.compileSdkVersion)
    buildToolsVersion(AppVersions.buildToolsVersion)
    defaultConfig {
        minSdkVersion(AppVersions.minSdkVersion)
        targetSdkVersion(AppVersions.targetSdkVersion)
        versionCode = AppVersions.versionCode
        versionName = AppVersions.versionName
        multiDexEnabled = true
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isTestCoverageEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
    }
    flavorDimensions("flavor")
    productFlavors {
        create("development") {}
        create("homolog") {}
        create("production") {}
    }
    sourceSets.forEach {
        val root = "src/androidMain/${it.name}"
        val manifestFile = file("src/androidMain/AndroidManifest.xml")
        it.setRoot(root)
        it.java.srcDirs += fileTree("${root}/kotlin")
        it.manifest.srcFile(manifestFile)
    }
    androidExtensions {
        isExperimental = true
    }
    lintOptions {
        isAbortOnError = false
    }
}

//endregion

//region Kotlin Multiplatform config

val MODULE_NAME = "KotlinSharedLibrary" // Nome do módulo

kotlin {

    val isIPhoneOS = System.getenv("SDK_NAME")?.startsWith("iphoneos") == true

    //select iOS target platform depending on the Xcode environment variables
    val iOSTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (isIPhoneOS) ::iosArm64
        else ::iosX64


    targetFromPreset(presets.getByName("android"), "android")

    iOSTarget("ios") {
        binaries {
            framework {
                baseName = MODULE_NAME
            }
        }
    }

    sourceSets["commonMain"].dependencies {
        api(KotlinDependencies.kotlinCommon)
    }

    sourceSets["commonTest"].dependencies {
        implementation(KotlinDependencies.kotlinTestCommon)
        implementation(KotlinDependencies.kotlinTestAnnotationsCommon)
    }

    sourceSets["androidMain"].dependencies {
        api(KotlinDependencies.kotlinStdlib)
        api(KotlinDependencies.kotlinAndroidExtensionsRuntime)
    }

    sourceSets["androidTest"].dependencies {
        implementation(AndroidDependencies.mockito)
        implementation(AndroidDependencies.jUnit)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    val targetDir = File(buildDir, "xcode-frameworks")

    /// selecting the right configuration for the iOS
    /// framework depending on the environment
    /// variables set by Xcode build
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
            .getByName<KotlinNativeTarget>("ios")
            .binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from({ framework.outputDirectory })
    into(targetDir)

    /// generate a helpful ./gradlew wrapper with embedded Java path
    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText("#!/bin/bash\n"
                + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
                + "cd '${rootProject.rootDir}'\n"
                + "./gradlew \$@\n")
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)

//endregion