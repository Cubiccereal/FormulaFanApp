package com.example.formulaonefanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.data.geojson.GeoJsonLayer
import com.google.maps.android.data.geojson.GeoJsonPoint
import org.json.JSONObject
import java.io.InputStream

class TrackLocationsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_locations)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // Setup zoom buttons
        val zoomInButton = findViewById<Button>(R.id.zoom_in_button)
        val zoomOutButton = findViewById<Button>(R.id.zoom_out_button)

        zoomInButton.setOnClickListener {
            googleMap.animateCamera(CameraUpdateFactory.zoomIn())
        }

        zoomOutButton.setOnClickListener {
            googleMap.animateCamera(CameraUpdateFactory.zoomOut())
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Load GeoJSON file
        val geoJsonData = loadGeoJsonFromAsset("f1locations.geojson")
        val layer = GeoJsonLayer(googleMap, geoJsonData)

        // Add the GeoJSON layer to the map
        layer.addLayerToMap()

        // Set custom info window adapter
        googleMap.setInfoWindowAdapter(CustomInfoWindowAdapter())

        // Move the camera to a specific location
        val initialLocation = LatLng(20.0, 0.0)  // Update with a default location
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 2.0f))

        // Add title and snippet to markers
        for (feature in layer.features) {
            val point = feature.geometry as? GeoJsonPoint
            if (point != null) {
                val coordinates = point.coordinates
                val markerOptions = MarkerOptions().position(LatLng(coordinates.latitude, coordinates.longitude))
                val marker = googleMap.addMarker(markerOptions)

                marker?.title = feature.getProperty("name")
                marker?.snippet = "Location: ${feature.getProperty("location")}, Opened: ${feature.getProperty("opened")}, First GP: ${feature.getProperty("firstgp")}, Length: ${feature.getProperty("length")} meters, Altitude: ${feature.getProperty("alt")} meters"
            }
        }

        // Set a marker click listener to show info window with the properties
        googleMap.setOnMarkerClickListener { marker ->
            marker.showInfoWindow()
            true
        }
    }

    private fun loadGeoJsonFromAsset(fileName: String): JSONObject {
        val inputStream: InputStream = assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonString = String(buffer, Charsets.UTF_8)
        return JSONObject(jsonString)
    }

    inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter {

        private val window: View = LayoutInflater.from(this@TrackLocationsActivity).inflate(R.layout.custom_info_window, null)

        override fun getInfoWindow(marker: Marker): View? {
            render(marker, window)
            return window
        }

        override fun getInfoContents(marker: Marker): View? {
            return null
        }

        private fun render(marker: Marker, view: View) {
            val title = marker.title ?: "No Title"
            val snippet = marker.snippet ?: "No Description"

            val tvTitle = view.findViewById<TextView>(R.id.title)
            val tvSnippet = view.findViewById<TextView>(R.id.snippet)

            tvTitle.text = title
            tvSnippet.text = snippet
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
