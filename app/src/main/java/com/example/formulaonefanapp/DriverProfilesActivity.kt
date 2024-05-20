package com.example.formulaonefanapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

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

class DriverProfilesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var driverProfileAdapter: DriverProfileAdapter
    private lateinit var driverProfileList: List<DriverProfile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_profiles)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        driverProfileList = loadDriverProfilesFromAsset()
        driverProfileAdapter = DriverProfileAdapter(driverProfileList)
        recyclerView.adapter = driverProfileAdapter
    }

    private fun loadDriverProfilesFromAsset(): List<DriverProfile> {
        val jsonString: String = try {
            val inputStream: InputStream = assets.open("Drivers.json")
            inputStream.bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return emptyList()
        }

        val gson = Gson()
        val listDriverProfileType = object : TypeToken<List<DriverProfile>>() {}.type
        return gson.fromJson(jsonString, listDriverProfileType)
    }
}