package com.example.formulaonefanapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonF1Store: ImageButton = findViewById(R.id.buttonF1Store)
        buttonF1Store.setOnClickListener {
            val url = "https://f1store.formula1.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        // buttons by their IDs
        val btnDriverDetails: ImageButton = findViewById(R.id.buttonDriverDetails)
        val btnLiveStandings: ImageButton = findViewById(R.id.buttonLiveStandings)
        val btnTrackLocations: ImageButton = findViewById(R.id.buttonTrackLocations)
        val btnSeasonCalendar: ImageButton = findViewById(R.id.buttonSeasonCalendar)

        //click listeners for each button to navigate to corresponding activities
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
