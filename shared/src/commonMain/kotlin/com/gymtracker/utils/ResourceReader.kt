package com.gymtracker.utils

interface ResourceReader {
    fun readResource(name: String): String
}

expect fun getResourceReader(): ResourceReader