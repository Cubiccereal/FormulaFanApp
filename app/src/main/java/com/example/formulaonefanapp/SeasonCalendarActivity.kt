package com.example.formulaonefanapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formulaonefanapp.model.RaceEvent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.nio.charset.Charset

class SeasonCalendarActivity : AppCompatActivity() {

    private lateinit var raceEventsRecyclerView: RecyclerView
    private lateinit var raceEventsAdapter: RaceEventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season_calendar)

        raceEventsRecyclerView = findViewById(R.id.raceEventsRecyclerView)
        raceEventsRecyclerView.layoutManager = LinearLayoutManager(this)
        raceEventsAdapter = RaceEventAdapter(emptyList())
        raceEventsRecyclerView.adapter = raceEventsAdapter

        fetchRaceEvents()
    }

    private fun fetchRaceEvents() {
        CoroutineScope(Dispatchers.IO).launch {
            val raceEventsJson = loadJSONFromAsset("race_schedule.json")
            val raceEventType = object : TypeToken<List<RaceEvent>>() {}.type
            val raceEvents: List<RaceEvent> = Gson().fromJson(raceEventsJson, raceEventType)

            withContext(Dispatchers.Main) {
                raceEventsAdapter = RaceEventAdapter(raceEvents)
                raceEventsRecyclerView.adapter = raceEventsAdapter
            }
        }
    }

    private fun loadJSONFromAsset(filename: String): String? {
        return try {
            val inputStream = assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }
}
