package br.alexandrehtrb.kotlinsharedlibrary

import platform.UIKit.UIDevice

actual fun getPlatformName(): String {
    return UIDevice.currentDevice.systemName() +
            " " +
            UIDevice.currentDevice.systemVersion
}