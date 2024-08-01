package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.fragments.my_happle.Show

class ShowAdapter(private val events: List<Show>) :
    RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        return ShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = events.size

    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgShow: ImageView = itemView.findViewById(R.id.img_show)
        private val tvTag: TextView = itemView.findViewById(R.id.tv_tag)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val tvDate: TextView = itemView.findViewById(R.id.tv_date)

        fun bind(event: Show) {
            imgShow.setImageResource(event.imgResId)
            tvTag.text = event.tag
            tvTitle.text = event.title
            tvDate.text = event.date
        }
    }
}