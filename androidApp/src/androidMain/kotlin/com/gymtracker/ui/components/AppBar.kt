package com.gymtracker.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gymtracker.ui.navigation.NavigationItem
import java.lang.reflect.Modifier

@Composable
fun TopBar(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var show by remember { mutableStateOf(false) }

    LaunchedEffect(navController.currentBackStackEntryFlow) {
        navController.currentBackStackEntryFlow.collect {
            println("APP BAR ROUTE ${it.destination} ${it.destination.route}")
            title = it.destination.route ?: ""
            show = NavigationItem.hasAppBar(it.destination.route)
        }
    }

    Surface(
//        modifier = Modifier.shadow(elevation = 3.dp)
    ) {
        if (show)
            TopAppBar(
                title = {
                    Text(
                        title.toUpperCase(),
                        color = Color.Black,
//                        style = MaterialTheme.typography.h1
                    )
                },
                backgroundColor = Color.White, contentColor = Color.White
            )
    }
}