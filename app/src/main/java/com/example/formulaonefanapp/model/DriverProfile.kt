package com.example.formulaonefanapp.model

data class DriverProfile(
    val driverId: Int,
    val driverRef: String,
    val number: String?,
    val code: String,
    val forename: String,
    val surname: String,
    val dob: String,
    val nationality: String
)
