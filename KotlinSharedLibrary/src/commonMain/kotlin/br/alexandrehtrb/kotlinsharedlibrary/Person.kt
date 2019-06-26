package br.alexandrehtrb.kotlinsharedlibrary

@Parcelize
data class Person(val name: String,
                  val age: Int,
                  val platformName: String): Parcelable, Serializable {

    constructor(name: String, age: Int):this(name, age, getPlatformName())

    fun createApplicationScreenMessage() : String {
        return "$name, $age years old, is using Kotlin Multiplatform in $platformName"
    }
}

expect fun getPlatformName(): String