echo Criando o modulo Kotlin Multiplatform...
mkdir SharedModule
cd SharedModule
echo "" > build.gradle

mkdir src
cd src

mkdir commonMain
cd commonMain
mkdir kotlin
cd kotlin
echo "package sharedmodule" > SharedClass1.kt
echo "" >> SharedClass1.kt
echo "abstract class SharedClass1 {" >> SharedClass1.kt
echo "	abstract val name: String" >> SharedClass1.kt
echo "" >> SharedClass1.kt
echo "}" >> SharedClass1.kt
cd ../..

mkdir commonTest
cd commonTest
mkdir kotlin
cd ..

mkdir androidMain
cd androidMain
mkdir kotlin
cd kotlin
echo "package sharedmodule" > AndroidClass1.kt
echo "" >> AndroidClass1.kt
echo "data class AndroidClass1(" >> AndroidClass1.kt
echo "	override val name: String): SharedClass1() {" >> AndroidClass1.kt
echo "" >> AndroidClass1.kt
echo "}" >> AndroidClass1.kt
cd ../..

mkdir androidTest
cd androidTest
mkdir kotlin
cd ..

mkdir iOSMain
cd iOSMain
mkdir kotlin
cd kotlin
echo "package sharedmodule" > IosClass1.kt
echo "" >> IosClass1.kt
echo "data class IosClass1(" >> IosClass1.kt
echo "	override val name: String): SharedClass1() {" >> IosClass1.kt
echo "" >> IosClass1.kt
echo "}" >> IosClass1.kt
cd ../..

mkdir iOSTest
cd iOSTest
mkdir kotlin
cd ..

echo A estrutura do modulo compartilhado foi criada!
echo Tambem foram criadas classes Kotlin em commonMain, androidMain e iOSMain.
echo Por favor, preencha o arquivo SharedModule/build.gradle com o conteudo do link:
echo https://gist.github.com/alexandrehtrb/d8002606e3fd251d1b652ae06d3c1cb4/
read -p "Pressione qualquer tecla para continuar..."