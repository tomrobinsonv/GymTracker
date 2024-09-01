package com.gymtracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gymtracker.ui.screens.ExerciseScreen
import com.gymtracker.ui.screens.ProfileScreen
import com.gymtracker.ui.screens.StartWorkoutScreen
import com.gymtracker.ui.screens.HistoryScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.StartWorkout.route) {
        composable(NavigationItem.StartWorkout.route) {
            StartWorkoutScreen()
        }
        composable(NavigationItem.History.route) {
            HistoryScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Exercises.route) {
            ExerciseScreen()
        }
    }
}
