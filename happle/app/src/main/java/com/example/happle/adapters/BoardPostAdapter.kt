package com.example.happle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.BoardPost

class BoardPostAdapter(private val boardPosts: List<BoardPost>) : RecyclerView.Adapter<BoardPostAdapter.BoardPostViewHolder>() {

    class BoardPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitle: TextView = view.findViewById(R.id.postTitle)
        val postContent: TextView = view.findViewById(R.id.postContent)
        val postTime: TextView = view.findViewById(R.id.postTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardPostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_board_post, parent, false)
        return BoardPostViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardPostViewHolder, position: Int) {
        val boardPost = boardPosts[position]
        holder.postTitle.text = boardPost.title
        holder.postContent.text = boardPost.content
        holder.postTime.text = boardPost.time
    }

    override fun getItemCount(): Int {
        return boardPosts.size
    }
}
