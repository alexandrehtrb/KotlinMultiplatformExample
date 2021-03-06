# Kotlin Multiplatform Example

App exemplo de Kotlin Multiplataforma, com suporte no Android para as interfaces java.io.Serializable e android.os.Parcelable.

[Read in english](https://github.com/alexandrehtrb/KotlinMultiplatformExample/blob/master/README.en.md)

## Ambiente de desenvolvimento para Android

Android Studio 3.5 ou superior

## Ambiente de desenvolvimento para iOS

XCode 10, Gradle 5.5.1, JDK 7 e 8, e Android SDK instalados, para gerar o `.framework` para o XCode e para desenvolver o app iOS.

## Como funciona

O projeto tem um módulo KotlinSharedLibrary, em Kotlin Multiplatform, que é compartilhado pelo KotlinSharedAndroid (app Android) e pelo KotlinSharedIOS (app iOS).

O app Android importa a KotlinSharedLibrary como um módulo.

Para o app iOS, é diferente: o projeto importa um arquivo `.framework` da KotlinSharedLibrary, que é gerado via uma task do Gradle.

Etapas:

* Executar a task **packForXCode** do build.gradle da KotlinSharedLibrary. Deve ser executada em um computador Mac.
* A task irá gerar um arquivo `.framework` localizado em: `/KotlinSharedLibrary/build/xcode-frameworks`.
* Esse framework deve ser importado pelo projeto iOS.
* O projeto iOS deve desabilitar Bitcode (no XCode, Build Settings > All > Enable Bitcode = No).

## Relatórios do JaCoCo

Para obter o relatório de cobertura de código por testes, execute a task do Gradle **:KotlinSharedLibrary:jacocoTestReportDebug**.

O relatório deverá ser gerado na pasta `KotlinSharedLibrary\build\reports\jacoco\debug`.

## Gradle KTS (Kotlin Script)

O projeto foi atualizado para começar a usar Gradle KTS. Antes, apenas Gradle com Groovy era usado; basta ver versões de commits anteriores.

## Mais informações

Mais informações em: https://kotlinlang.org/docs/tutorials/native/mpp-ios-android.html

O suporte a Serializable e Parcelable foi baseado no artigo: https://aakira.app/blog/2019/04/kotlin-mpp-android-parcelable-en/

Ver também o projeto: https://github.com/AAkira/KotlinMultiplatformAndoridParcelize
