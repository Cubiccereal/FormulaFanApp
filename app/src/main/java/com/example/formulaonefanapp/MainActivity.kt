package com.example.formulaonefanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find buttons by their IDs
        val btnDriverDetails: ImageButton = findViewById(R.id.buttonDriverDetails)
        val btnLiveStandings: ImageButton = findViewById(R.id.buttonLiveStandings)
        val btnTrackLocations: ImageButton = findViewById(R.id.buttonTrackLocations)
        val btnSeasonCalendar: ImageButton = findViewById(R.id.buttonSeasonCalendar)

        // Set click listeners for each button to navigate to corresponding activities
        btnDriverDetails.setOnClickListener {
            val intent = Intent(this, DriverProfilesActivity::class.java)
            startActivity(intent)
        }

        btnLiveStandings.setOnClickListener {
            val intent = Intent(this, LiveStandingsActivity::class.java)
            startActivity(intent)
        }

        btnTrackLocations.setOnClickListener {
            val intent = Intent(this, TrackLocationsActivity::class.java)
            startActivity(intent)
        }

        btnSeasonCalendar.setOnClickListener {
            val intent = Intent(this, SeasonCalendarActivity::class.java)
            startActivity(intent)
        }
    }
}
