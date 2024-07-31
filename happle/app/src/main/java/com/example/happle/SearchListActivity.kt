package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.BandListAdapter
import com.example.happle.model.Band
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchListActivity : AppCompatActivity() {
    private lateinit var bandListAdapter: BandListAdapter
    private lateinit var bands: List<Band>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        // Band 객체 생성 시 모든 필드 값 제공
        bands = listOf(
            Band(id = 1, name = "SUMMIT", description = "IT 대학 밴드", imageResId = R.drawable.sample_band1, rating = 4.5, location = "서울"),
            Band(id = 2, name = "어울림", description = "어울림 밴드", imageResId = R.drawable.sample_band2, rating = 4.0, location = "부산"),
            Band(id = 3, name = "크림슨", description = "크림슨 밴드", imageResId = R.drawable.sample_band3, rating = 3.8, location = "대구"),
            Band(id = 4, name = "광야", description = "광야 밴드", imageResId = R.drawable.sample_band4, rating = 4.2, location = "광주"),
            Band(id = 5, name = "킨젝스", description = "킨젝스 밴드", imageResId = R.drawable.sample_band5, rating = 4.7, location = "인천"),
            Band(id = 6, name = "소나기", description = "소나기 밴드", imageResId = R.drawable.sample_band6, rating = 4.3, location = "수원"),
            Band(id = 7, name = "메아리", description = "메아리 밴드", imageResId = R.drawable.sample_band7, rating = 4.4, location = "전주"),
            Band(id = 8, name = "수선관 그 밴드", description = "수선관 밴드", imageResId = R.drawable.sample_band8, rating = 3.9, location = "대전"),
            Band(id = 9, name = "블루 드래곤", description = "블루 드래곤 밴드", imageResId = R.drawable.sample_band9, rating = 4.6, location = "울산")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // onBandClick 구현
        val onBandClick: (Band) -> Unit = { band ->
            val intent = Intent(this, MyHappleActivity::class.java)
            intent.putExtra("bandId", band.id)
            startActivity(intent)
        }

        // BandListAdapter를 item_band_list.xml을 사용하도록 설정
        bandListAdapter = BandListAdapter(bands, onBandClick)
        recyclerView.adapter = bandListAdapter

        // SearchView 설정
        val searchView = findViewById<SearchView>(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    filterBands(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    filterBands(it)
                }
                return true
            }
        })

        // BottomNavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_my_happle

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_calendar -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_my_happle -> {
                    val intent = Intent(this, MyBandsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_board -> {
                    val intent = Intent(this, BoardActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun filterBands(query: String) {
        val filteredBands = if (query.isEmpty()) {
            bands
        } else {
            bands.filter { it.name.contains(query, ignoreCase = true) }
        }
        bandListAdapter.updateBands(filteredBands)
    }
}
