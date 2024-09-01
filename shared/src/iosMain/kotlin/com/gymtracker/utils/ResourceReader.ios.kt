package com.gymtracker.utils

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithContentsOfFile
import platform.darwin.NSObject
import platform.darwin.NSObjectMeta

@OptIn(ExperimentalForeignApi::class)
class IOSResourceReader: ResourceReader {
    @OptIn(BetaInteropApi::class)
    private val bundle: NSBundle = NSBundle.bundleForClass(BundleMarker)

    override fun readResource(name: String): String {
        val (filename, type) = when (val lastPeriodIndex = name.lastIndexOf('.')) {
            0 -> {
                null to name.drop(1)
            }
            in 1..Int.MAX_VALUE -> {
                name.take(lastPeriodIndex) to name.drop(lastPeriodIndex + 1)
            }
            else -> {
                name to null
            }
        }
        val path = bundle.pathForResource(filename, type) ?: error(
            "Couldn't get path of $name (parsed as: ${listOfNotNull(filename,type).joinToString(".")})"
        )

        return memScoped {
            NSString.stringWithContentsOfFile(
                path,
                encoding = NSUTF8StringEncoding,
                error = null
            ) ?: run {
                error("Couldn't load resource: $name. Error: ")
            }
        }
    }

    private class BundleMarker : NSObject() {
        companion object : NSObjectMeta()
    }
}

actual fun getResourceReader(): ResourceReader = IOSResourceReader()