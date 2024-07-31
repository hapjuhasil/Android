package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R

class AddButtonAdapter(
    private val onAddClick: () -> Unit
) : RecyclerView.Adapter<AddButtonAdapter.AddViewHolder>() {

    class AddViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_band, parent, false)
        return AddViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddViewHolder, position: Int) {
        holder.itemView.setOnClickListener { onAddClick() }
    }

    override fun getItemCount(): Int {
        return 1 // 항상 + 버튼 하나만
    }
}
