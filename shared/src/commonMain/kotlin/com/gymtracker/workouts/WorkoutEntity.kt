package com.gymtracker.workouts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkoutEntity(
    @SerialName("ID") val id: String,
    @SerialName("Name") val name: String,
    @SerialName("Exercise") val exercise: String? = null,
    @SerialName("Exercise type") val exerciseType: String,
    @SerialName("BodyPart") val bodyPart: String,
    @SerialName("Equipment") val equipment: String,
    @SerialName("Gender") val gender: String,
    @SerialName("Target") val target: String,
    @SerialName("Synergist") val synergist: String
)