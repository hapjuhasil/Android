package com.example.happle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Band(val name: String, val imageResId: Int)

class BandAdapter(private val bands: List<Band>) : RecyclerView.Adapter<BandAdapter.BandViewHolder>() {

    class BandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bandImageView: ImageView = view.findViewById(R.id.bandImageView)
        val bandNameTextView: TextView = view.findViewById(R.id.bandNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_band, parent, false)
        return BandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BandViewHolder, position: Int) {
        val band = bands[position]
        holder.bandImageView.setImageResource(band.imageResId)
        holder.bandNameTextView.text = band.name
    }

    override fun getItemCount(): Int {
        return bands.size
    }
}
