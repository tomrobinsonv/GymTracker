package com.gymtracker.utils

import java.io.InputStreamReader

class AndroidResourceReader: ResourceReader {
    override fun readResource(name: String): String =
        javaClass.classLoader!!.getResourceAsStream(name).use { stream ->
            InputStreamReader(stream).use { reader ->
                reader.readText()
            }
        }
}

actual fun getResourceReader(): ResourceReader = AndroidResourceReader()