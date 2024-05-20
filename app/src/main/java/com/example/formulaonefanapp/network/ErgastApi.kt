package com.example.formulaonefanapp.network

import com.example.formulaonefanapp.model.DriverStandingsResponse
import retrofit2.http.GET

interface ErgastApi {
    @GET("current/driverStandings.json")
    suspend fun getDriverStandings(): DriverStandingsResponse
}
