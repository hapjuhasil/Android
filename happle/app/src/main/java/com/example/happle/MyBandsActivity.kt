package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.BandAdapter
import com.example.happle.model.Band
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyBandsActivity : AppCompatActivity() {

    private lateinit var bandAdapter: BandAdapter
    private lateinit var bandListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bands)

        // 툴바 설정
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // 추가 버튼 설정
        val addBandButton: ImageView = findViewById(R.id.addBandButton)
        addBandButton.setOnClickListener {
            val intent = Intent(this, SearchListActivity::class.java)
            startActivity(intent)
        }

        // 밴드 리스트 설정
        bandListRecyclerView = findViewById(R.id.bandListRecyclerView)
        bandListRecyclerView.layoutManager = LinearLayoutManager(this)

        // 샘플 데이터
        val bands = listOf(
            Band(id = 1, name = "SUMMIT", description = "설명 1", imageResId = R.drawable.img_summit, rating = 4.5, location = "서울"),
            Band(id = 2, name = "밴드 2", description = "설명 2", imageResId = R.drawable.img_summit, rating = 4.0, location = "부산")
        )

        // 어댑터 설정
        bandAdapter = BandAdapter(bands) { band ->
            val intent = Intent(this, MyHappleActivity::class.java)
            intent.putExtra("bandId", band.id)
            startActivity(intent)
        }

        bandListRecyclerView.adapter = bandAdapter

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
}
