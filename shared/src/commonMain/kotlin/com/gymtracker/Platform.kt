package com.gymtracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform