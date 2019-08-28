// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://dl.bintray.com/jetbrains/kotlin-native-dependencies") }
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.androidGradlePlugin)
        classpath(Plugins.androidJacocoPlugin)
        classpath(Plugins.kotlinGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
        maven { url = uri("https://jitpack.io") }
    }
}

val clean by tasks.creating(Delete::class) {
    delete(rootProject.buildDir)
}