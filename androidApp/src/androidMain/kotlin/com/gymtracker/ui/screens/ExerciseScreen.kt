package com.gymtracker.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.gymtracker.workouts.WorkoutEntity
import com.gymtracker.workouts.WorkoutRepository

@Composable
fun ExerciseScreen() {
    MaterialTheme {
        val workoutContent = remember { mutableStateListOf<WorkoutEntity>() }
        LaunchedEffect(Unit) {
            workoutContent.addAll(WorkoutRepository().getWorkouts())
        }
        Column(
            androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (workoutContent.isEmpty())
                Text("EMPTY STATE")
            else
                LazyColumn(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                    items(workoutContent.size) { index ->
                        Text(workoutContent[index].name)
                    }
                }
        }
    }
}

@Preview
@Composable
fun ExerciseScreenPreview() {
    ExerciseScreen()
}