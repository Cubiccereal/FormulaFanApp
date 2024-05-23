package com.example.formulaonefanapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formulaonefanapp.model.Event
import com.example.formulaonefanapp.model.RaceEvent


class RaceEventAdapter(private val raceEvents: List<RaceEvent>) :
    RecyclerView.Adapter<RaceEventAdapter.RaceEventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceEventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_race_event, parent, false)
        return RaceEventViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaceEventViewHolder, position: Int) {
        val raceEvent = raceEvents[position]
        holder.bind(raceEvent)
    }

    override fun getItemCount(): Int {
        return raceEvents.size
    }

    class RaceEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val gpTextView: TextView = itemView.findViewById(R.id.gpTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        private val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        private val eventsRecyclerView: RecyclerView = itemView.findViewById(R.id.eventsRecyclerView)

        fun bind(raceEvent: RaceEvent) {
            gpTextView.text = raceEvent.gp
            dateTextView.text = raceEvent.date
            timeTextView.text = raceEvent.time
            eventsRecyclerView.adapter = EventAdapter(raceEvent.events)
        }
    }
}

class EventAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val eventTypeTextView: TextView = itemView.findViewById(R.id.eventTypeTextView)
        private val eventDateTextView: TextView = itemView.findViewById(R.id.eventDateTextView)
        private val eventTimeTextView: TextView = itemView.findViewById(R.id.eventTimeTextView)

        fun bind(event: Event) {
            eventTypeTextView.text = event.type
            eventDateTextView.text = event.date
            eventTimeTextView.text = event.time
        }
    }
}
