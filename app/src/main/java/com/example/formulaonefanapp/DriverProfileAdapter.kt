package com.example.formulaonefanapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DriverProfileAdapter(private val driverProfileList: List<DriverProfile>) :
    RecyclerView.Adapter<DriverProfileAdapter.DriverProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_driver_profile, parent, false)
        return DriverProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: DriverProfileViewHolder, position: Int) {
        val driverProfile = driverProfileList[position]
        holder.bind(driverProfile)
    }

    override fun getItemCount(): Int {
        return driverProfileList.size
    }

    class DriverProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val dobTextView: TextView = itemView.findViewById(R.id.dobTextView)
        private val nationalityTextView: TextView = itemView.findViewById(R.id.nationalityTextView)
        private val codeTextView: TextView = itemView.findViewById(R.id.codeTextView)
        private val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)

        fun bind(driverProfile: DriverProfile) {
            nameTextView.text = "${driverProfile.forename} ${driverProfile.surname}"
            dobTextView.text = "Date of Birth: ${driverProfile.dob}"
            nationalityTextView.text = "Nationality: ${driverProfile.nationality}"
            codeTextView.text = "Code: ${driverProfile.code}"
            numberTextView.text = "Number: ${driverProfile.number ?: "N/A"}"
        }
    }
}
