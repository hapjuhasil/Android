package com.example.happle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        val bands = listOf(
            Band("SUMMIT", R.drawable.sample_band1),
            Band("어울림", R.drawable.sample_band2),
            Band("크림슨", R.drawable.sample_band3),
            Band("광야", R.drawable.sample_band4),
            Band("킨젝스", R.drawable.sample_band5),
            Band("소나기", R.drawable.sample_band6),
            Band("메아리", R.drawable.sample_band7),
            Band("수선관 그 밴드", R.drawable.sample_band8),
            Band("블루 드래곤", R.drawable.sample_band9)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3) // 3개의 열로 설정
        recyclerView.adapter = BandAdapter(bands)
    }
}
