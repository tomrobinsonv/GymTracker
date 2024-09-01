package com.gymtracker.workouts

import com.gymtracker.utils.ResourceReader
import com.gymtracker.utils.getResourceReader
import kotlinx.serialization.json.Json

class WorkoutRepository {

    private val resourceReader: ResourceReader = getResourceReader()

    fun getWorkouts(): List<WorkoutEntity> {
        try {
            val exerciseJson = resourceReader.readResource("exercises.json")
            val exercises = Json.decodeFromString<List<WorkoutEntity>>(exerciseJson)

            println("RESOURCES ${exercises::class.simpleName} ${exercises.size}")
            return exercises
        } catch(e: Exception) {
            println("error here $e")
            throw e
        }
    }
}