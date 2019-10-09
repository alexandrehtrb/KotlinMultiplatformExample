plugins {
    id("com.android.application")
    id("kotlin-android") // or id("com.android.application")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AppVersions.compileSdkVersion)
    buildToolsVersion(AppVersions.buildToolsVersion)
    defaultConfig {
        applicationId = AppVersions.applicationId
        minSdkVersion(AppVersions.minSdkVersion)
        targetSdkVersion(AppVersions.targetSdkVersion)
        versionCode = AppVersions.versionCode
        versionName = AppVersions.versionName
        testInstrumentationRunner = AppVersions.testInstrumentationRunner
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isTestCoverageEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
    }
    flavorDimensions("flavor")
    productFlavors {
        create("development") {
            applicationIdSuffix = ".development"
        }
        create("homolog") {
            applicationIdSuffix = ".homolog"
        }
        create("production") {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packagingOptions {
        exclude("META-INF/rxjava.properties")
    }
    dataBinding {
        isEnabled = true
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }
    lintOptions {
        isAbortOnError = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":KotlinSharedLibrary"))

    implementation(KotlinDependencies.kotlinStdlibJdk7)
    implementation(AndroidDependencies.appCompat)
    implementation(AndroidDependencies.multidex)
    implementation(AndroidDependencies.espressoIdlingResource)
    implementation(AndroidDependencies.constraintLayout)

    testImplementation(AndroidDependencies.mockito)
    testImplementation(AndroidDependencies.jUnit)

    androidTestImplementation(AndroidDependencies.mockito)
    androidTestImplementation(AndroidDependencies.annotation)
    androidTestImplementation(AndroidDependencies.espressoCore)
    androidTestImplementation(AndroidDependencies.espressoContrib)
    androidTestImplementation(AndroidDependencies.espressoIntents)
    androidTestImplementation(AndroidDependencies.espressoIdlingConcurrent)
    androidTestImplementation(AndroidDependencies.testRules)
    androidTestImplementation(AndroidDependencies.testRunner)
    androidTestImplementation(AndroidDependencies.uiAutomator)
    androidTestImplementation(AndroidDependencies.dexMakerMockito)
    androidTestImplementation(AndroidDependencies.testButler)
}