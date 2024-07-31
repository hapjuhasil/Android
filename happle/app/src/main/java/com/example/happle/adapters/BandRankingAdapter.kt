package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.Band

class BandRankingAdapter(private val bandList: List<Band>) : RecyclerView.Adapter<BandRankingAdapter.BandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_band_ranking, parent, false)
        return BandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BandViewHolder, position: Int) {
        val band = bandList[position]
        holder.bandRank.text = (position + 1).toString()
        holder.bandName.text = band.name
        holder.universityName.text = band.description
        holder.bandScore.text = band.rating.toString()
        holder.ratingCount.text = band.location
        holder.bandImage.setImageResource(band.imageResId)
    }

    override fun getItemCount() = bandList.size

    inner class BandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bandRank: TextView = itemView.findViewById(R.id.bandRank)
        val bandName: TextView = itemView.findViewById(R.id.bandName)
        val universityName: TextView = itemView.findViewById(R.id.universityName)
        val bandScore: TextView = itemView.findViewById(R.id.bandScore)
        val ratingCount: TextView = itemView.findViewById(R.id.ratingCount)
        val bandImage: ImageView = itemView.findViewById(R.id.bandImage)
    }
}
