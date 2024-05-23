package com.example.formulaonefanapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formulaonefanapp.model.DriverProfile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DriverProfilesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var driverProfileAdapter: DriverProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_profiles)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val drivers = loadDriversFromJson()
        driverProfileAdapter = DriverProfileAdapter(drivers)
        recyclerView.adapter = driverProfileAdapter
    }

    private fun loadDriversFromJson(): List<DriverProfile> {
        val jsonString: String
        try {
            jsonString = assets.open("Drivers.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return emptyList()
        }

        val listDriverType = object : TypeToken<List<DriverProfile>>() {}.type
        return Gson().fromJson(jsonString, listDriverType)
    }
}
