# Kotlin Multiplatform Example

Example app in Kotlin Multiplatform, with support to java.io.Serializable and android.os.Parcelable interfaces in Android.

[Leia em português](https://github.com/alexandrehtrb/KotlinMultiplatformExample/blob/master/README.md)

## Tools required for Android

Android Studio 3.5 or higher

## Tools required for iOS

XCode 10, Gradle 5.5.1, JDK 7 and 8, and Android SDK installed, to generate the `.framework` for XCode and to develop the iOS app.

## How it works

The project has a KotlinSharedLibrary module, in Kotlin Multiplatform, that is shared between KotlinSharedAndroid (Android app) and KotlinSharedIOS (iOS app).

The Android app imports the KotlinSharedLibrary as a module.

For the iOS app, it is different: the project imports the `.framework` file generated from KotlinSharedLibrary by a Gradle task.

Steps:

* Execute the **packForXCode** of KotlinSharedLibrary's build.gradle. Should be ran in a Mac computer.
* The task will create the `.framework` file in the folder: `/KotlinSharedLibrary/build/xcode-frameworks`.
* This framework needs to be imported by the iOS project.
* The iOS project needs to disable BitCode (in XCode, Build Settings > All > Enable Bitcode = No).

## JaCoCo reports

To obtain the code test coverage report, execute the Gradle task **:KotlinSharedLibrary:jacocoTestReportDebug**. 

The report should be generated in the folder `KotlinSharedLibrary\build\reports\jacoco\debug`.

## Gradle KTS (Kotlin Script)

The project was updated to begin using Gradle KTS. Before, only Gradle with Groovy was used; those Gradle scripts can be seen in files from older commits.

## More information

More information in: https://kotlinlang.org/docs/tutorials/native/mpp-ios-android.html

The support for Serializable and Parcelable was based in the article: https://aakira.app/blog/2019/04/kotlin-mpp-android-parcelable-en/

Check this project too: https://github.com/AAkira/KotlinMultiplatformAndoridParcelize
