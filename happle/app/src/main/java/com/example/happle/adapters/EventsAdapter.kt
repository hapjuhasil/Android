package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.Event

class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    private var events: List<Event> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    fun submitList(events: List<Event>) {
        this.events = events
        notifyDataSetChanged()
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.eventTitle)
        private val description: TextView = itemView.findViewById(R.id.eventDescription)
        private val time: TextView = itemView.findViewById(R.id.eventTime)

        fun bind(event: Event) {
            title.text = event.title
            description.text = event.description
            time.text = event.time
        }
    }
}
