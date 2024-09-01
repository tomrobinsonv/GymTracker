package com.gymtracker.ui.navigation

import com.gymtracker.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String, var hasAppBar: Boolean) {
    data object Profile : NavigationItem("profile", R.drawable.history_icon, "Profile", false)
    data object StartWorkout : NavigationItem("StartWorkout", R.drawable.start_workout_icon, "Start Workout", false)
    data object History : NavigationItem("history", R.drawable.history_icon, "History", false)
    data object Exercises : NavigationItem("exercises", R.drawable.exercises_icon, "Exercises", true)

    companion object {
        private val appBarScreens: List<NavigationItem> = listOf(
            Exercises
        )

        fun hasAppBar(route: String?): Boolean {
            println("CHECKIng now")
            val screen = appBarScreens.firstOrNull {
                println("ROUTE GIVEN $route")
                println("CHECK ROUTE ${it.route}")
                it.route == route
            }
            println("CHECKIGNgggg ${screen}")
            return screen?.hasAppBar ?: false
        }
    }
}