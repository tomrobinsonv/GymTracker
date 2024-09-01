package com.gymtracker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.gymtracker.ui.components.TopBar
import com.gymtracker.ui.navigation.BottomNavigationBar
import com.gymtracker.ui.navigation.Navigation


@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->

            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = Color.White
    )
}