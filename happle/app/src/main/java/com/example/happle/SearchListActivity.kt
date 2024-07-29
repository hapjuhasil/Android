package com.example.happle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.BandAdapter
import com.example.happle.model.Band

class SearchListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val bands = listOf(
            Band("SUMMIT", R.drawable.sample_band1),
            Band("어울림", R.drawable.sample_band2),
            Band("크림슨", R.drawable.sample_band3),
            Band("광야", R.drawable.sample_band4),
            Band("킨젝스", R.drawable.sample_band5),
            Band("소나기", R.drawable.sample_band6)
        )

        val adapter = BandAdapter(bands)
        recyclerView.adapter = adapter
    }
}
