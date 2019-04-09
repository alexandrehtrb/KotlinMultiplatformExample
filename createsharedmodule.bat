@echo OFF
echo Criando o modulo Kotlin Multiplatform...
mkdir SharedModule\src\commonMain\kotlin
mkdir SharedModule\src\commonTest\kotlin
mkdir SharedModule\src\androidMain\kotlin
mkdir SharedModule\src\androidTest\kotlin
mkdir SharedModule\src\iOSMain\kotlin
mkdir SharedModule\src\iOSTest\kotlin

type NUL > SharedModule\build.gradle

echo package sharedmodule > SharedModule\src\commonMain\kotlin\SharedClass1.kt
echo. >> SharedModule\src\commonMain\kotlin\SharedClass1.kt
echo abstract class SharedClass1 { >> SharedModule\src\commonMain\kotlin\SharedClass1.kt
echo 	abstract val name: String >> SharedModule\src\commonMain\kotlin\SharedClass1.kt
echo. >> SharedModule\src\commonMain\kotlin\SharedClass1.kt
echo } >> SharedModule\src\commonMain\kotlin\SharedClass1.kt

echo package sharedmodule > SharedModule\src\androidMain\kotlin\AndroidClass1.kt
echo. >> SharedModule\src\androidMain\kotlin\AndroidClass1.kt
echo data class AndroidClass1( >> SharedModule\src\androidMain\kotlin\AndroidClass1.kt
echo 	override val name: String): SharedClass1() { >> SharedModule\src\androidMain\kotlin\AndroidClass1.kt
echo. >> SharedModule\src\androidMain\kotlin\AndroidClass1.kt
echo } >> SharedModule\src\androidMain\kotlin\AndroidClass1.kt

echo package sharedmodule > SharedModule\src\iOSMain\kotlin\IosClass1.kt
echo. >> SharedModule\src\iOSMain\kotlin\IosClass1.kt
echo data class IosClass1( >> SharedModule\src\iOSMain\kotlin\IosClass1.kt
echo 	override val name: String): SharedClass1() { >> SharedModule\src\iOSMain\kotlin\IosClass1.kt
echo. >> SharedModule\src\iOSMain\kotlin\IosClass1.kt
echo } >> SharedModule\src\iOSMain\kotlin\IosClass1.kt

echo A estrutura do modulo compartilhado foi criada!
echo Tambem foram criadas classes Kotlin em commonMain, androidMain e iOSMain.
echo Por favor, preencha o arquivo SharedModule\build.gradle com o conteudo do link:
echo https://gist.github.com/alexandrehtrb/d8002606e3fd251d1b652ae06d3c1cb4/
pause