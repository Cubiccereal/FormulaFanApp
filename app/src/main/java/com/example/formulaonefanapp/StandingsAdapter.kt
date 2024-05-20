package com.example.formulaonefanapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formulaonefanapp.model.DriverStanding

class StandingsAdapter : RecyclerView.Adapter<StandingsAdapter.ViewHolder>() {

    private var standingsList = listOf<DriverStanding>()

    fun setData(data: List<DriverStanding>) {
        standingsList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_standing, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val standing = standingsList[position]
        holder.bind(standing)
    }

    override fun getItemCount(): Int {
        return standingsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val driverNameTextView: TextView = itemView.findViewById(R.id.driverName)
        private val pointsTextView: TextView = itemView.findViewById(R.id.points)

        fun bind(standing: DriverStanding) {
            driverNameTextView.text = "${standing.Driver.givenName} ${standing.Driver.familyName}"
            pointsTextView.text = "Points: ${standing.points}"
        }
    }
}
