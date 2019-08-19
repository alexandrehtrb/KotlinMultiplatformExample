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

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${PluginVersions.kotlinVersion}")
    implementation("com.android.support:appcompat-v7:${DependenciesVersions.androidSupportVersion}")
    implementation("com.android.support:multidex:${DependenciesVersions.multidexVersion}")
    implementation("com.android.support.test.espresso:espresso-idling-resource:${DependenciesVersions.espressoVersion}")
    implementation("com.android.support.constraint:constraint-layout:${DependenciesVersions.constraintLayoutVersion}")

    // for tests only
    val mockito = "org.mockito:mockito-core:${DependenciesVersions.mockitoVersion}"

    testImplementation(mockito)
    testImplementation("junit:junit:${DependenciesVersions.jUnitVersion}")

    androidTestImplementation(mockito)
    androidTestImplementation("com.android.support:support-annotations:${DependenciesVersions.androidSupportVersion}")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:${DependenciesVersions.espressoVersion}")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:${DependenciesVersions.espressoVersion}")
    androidTestImplementation("com.android.support.test.espresso:espresso-intents:${DependenciesVersions.espressoVersion}")
    androidTestImplementation("com.android.support.test.espresso.idling:idling-concurrent:${DependenciesVersions.espressoVersion}")
    androidTestImplementation("com.android.support.test:rules:${DependenciesVersions.testRunnerVersion}")
    androidTestImplementation("com.android.support.test:runner:${DependenciesVersions.testRunnerVersion}")
    androidTestImplementation("com.android.support.test.uiautomator:uiautomator-v18:${DependenciesVersions.uiAutomatorVersion}")
    androidTestImplementation("com.linkedin.dexmaker:dexmaker-mockito:${DependenciesVersions.dexMakerVersion}")
    androidTestImplementation("com.linkedin.testbutler:test-butler-library:${DependenciesVersions.testButlerVersion}")
}