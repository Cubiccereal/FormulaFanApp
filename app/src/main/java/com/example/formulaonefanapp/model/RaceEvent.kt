package com.example.formulaonefanapp.model

data class RaceEvent(
    val gp: String,
    val date: String,
    val time: String,
    val events: List<Event>
)

data class Event(
    val type: String,
    val date: String,
    val time: String
)
