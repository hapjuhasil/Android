package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.Band

class BandListAdapter(
    private var bands: List<Band>,
    private val onBandClick: (Band) -> Unit
) : RecyclerView.Adapter<BandListAdapter.BandViewHolder>() {

    class BandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bandImageView: ImageView = view.findViewById(R.id.bandImageView)
        val bandNameTextView: TextView = view.findViewById(R.id.bandNameTextView)
        // 팔로우 버튼과 설명 텍스트 뷰는 제거됨
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_band_list, parent, false)
        return BandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BandViewHolder, position: Int) {
        val band = bands[position]
        holder.bandNameTextView.text = band.name
        holder.bandImageView.setImageResource(band.imageResId)

        holder.itemView.setOnClickListener { onBandClick(band) }
    }

    override fun getItemCount(): Int = bands.size

    fun updateBands(newBands: List<Band>) {
        bands = newBands
        notifyDataSetChanged()
    }
}
