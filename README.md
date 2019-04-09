# Kotlin Multiplatform Project

App exemplo de Kotlin Multiplataforma.

## Ambiente de desenvolvimento para Android

Android Studio 3.3 ou superior

Link para download (Android Studio Canary):

**Windows**: https://dl.google.com/dl/android/studio/ide-zips/3.5.0.7/android-studio-ide-191.5375575-windows.zip

**Linux**: https://dl.google.com/dl/android/studio/ide-zips/3.5.0.7/android-studio-ide-191.5375575-linux.zip

**Mac OS**: https://dl.google.com/dl/android/studio/ide-zips/3.5.0.7/android-studio-ide-191.5375575-mac.zip

## Ambiente de desenvolvimento para iOS

Gradle e JDK, para gerar o `.framework` para o XCode. É necessário ter o Android SDK instalado.

## Como funciona

O projeto tem um módulo KotlinSharedLibrary, em Kotlin Multiplatform, que é compartilhado pelo KotlinSharedAndroid (app Android) e pelo KotlinSharedIOS (app iOS).

O app Android importa a KotlinSharedLibrary como um módulo.

Para o app iOS, é diferente: o projeto importa um arquivo `.framework` da KotlinSharedLibrary, que é gerado via uma task do Gradle.

Etapas:

* Executar a task **packForXCode** do build.gradle da KotlinSharedLibrary. Deve ser executada em um computador Mac.
* A task irá gerar um arquivo `.framework` localizado em: `/KotlinSharedLibrary/build/xcode-frameworks`.
* Esse framework deve ser importado pelo projeto iOS.
* O projeto iOS deve desabilitar Bitcode (no XCode, Build Settings > All > Enable Bitcode = No).

## Mais informações

Mais informações em: https://kotlinlang.org/docs/tutorials/native/mpp-ios-android.html