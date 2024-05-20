package com.example.formulaonefanapp.model

data class DriverStandingsResponse(
    val MRData: MRData
)

data class MRData(
    val StandingsTable: StandingsTable
)

data class StandingsTable(
    val StandingsLists: List<StandingsList>
)

data class StandingsList(
    val season: String,
    val round: String,
    val DriverStandings: List<DriverStanding>
)

data class DriverStanding(
    val position: String,
    val points: String,
    val wins: String,
    val Driver: Driver,
    val Constructors: List<Constructor>
)

data class Driver(
    val driverId: String,
    val givenName: String,
    val familyName: String,
    val nationality: String
)

data class Constructor(
    val constructorId: String,
    val name: String,
    val nationality: String
)
