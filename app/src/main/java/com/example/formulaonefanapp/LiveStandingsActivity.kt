package com.example.formulaonefanapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formulaonefanapp.network.RetrofitInstance
import com.example.formulaonefanapp.model.DriverStanding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LiveStandingsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var standingsAdapter: StandingsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_standings)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        standingsAdapter = StandingsAdapter()
        recyclerView.adapter = standingsAdapter

        fetchDriverStandings()
    }

    private fun fetchDriverStandings() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.api.getDriverStandings()
            withContext(Dispatchers.Main) {
                standingsAdapter.setData(response.MRData.StandingsTable.StandingsLists[0].DriverStandings)
            }
        }
    }
}
