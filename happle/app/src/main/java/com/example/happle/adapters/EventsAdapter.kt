package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.Event

class EventsAdapter(private val eventList: List<Event>) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.event_title)
        val location: TextView = itemView.findViewById(R.id.event_location)
        val time: TextView = itemView.findViewById(R.id.event_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = eventList[position]
        holder.title.text = event.title
        holder.location.text = event.description
        holder.time.text = event.time
    }

    override fun getItemCount(): Int = eventList.size
}
