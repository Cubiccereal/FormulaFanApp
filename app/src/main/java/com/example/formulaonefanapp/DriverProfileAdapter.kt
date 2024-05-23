package com.example.formulaonefanapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formulaonefanapp.model.DriverProfile

class DriverProfileAdapter(private val drivers: List<DriverProfile>) :
    RecyclerView.Adapter<DriverProfileAdapter.DriverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_driver_profile, parent, false)
        return DriverViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val driver = drivers[position]
        holder.driverName.text = "${driver.forename} ${driver.surname}"
        holder.driverTeam.text = driver.nationality
        holder.driverPoints.text = driver.dob
    }

    override fun getItemCount() = drivers.size

    class DriverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val driverName: TextView = itemView.findViewById(R.id.driverName)
        val driverTeam: TextView = itemView.findViewById(R.id.driverTeam)
        val driverPoints: TextView = itemView.findViewById(R.id.driverPoints)
    }
}
