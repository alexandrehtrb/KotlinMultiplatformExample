package br.alexandrehtrb.kotlinsharedlibrary

import android.os.Build

actual fun getPlatformName(): String {
    return "Android ${Build.VERSION.RELEASE}"
}