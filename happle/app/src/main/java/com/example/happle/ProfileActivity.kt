package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.BandAdapter
import com.example.happle.model.Band
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    private lateinit var bandAdapter: BandAdapter
    private lateinit var profileName: TextView
    private lateinit var profileSettings: TextView
    private lateinit var recentBandsRecyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 뷰 초기화
        profileName = findViewById(R.id.profileName)
        profileSettings = findViewById(R.id.profileSettings)
        recentBandsRecyclerView = findViewById(R.id.recentBandsRecyclerView)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // 프로필 이름 설정
        profileName.text = "땡이님"

        // 프로필 설정 클릭 리스너 설정
        profileSettings.setOnClickListener {
            // 프로필 설정 화면으로 이동하는 동작 정의
            val intent = Intent(this, ProfileSettingsActivity::class.java)
            startActivity(intent)
        }

        // 최근에 본 밴드 RecyclerView 설정
        val recentBands = listOf(
            Band(id = 1, name = "SUMMIT", description = "설명 1", imageResId = R.drawable.img_summit, rating = 4.5, location = "서울"),
            Band(id = 2, name = "SUMMIT", description = "설명 2", imageResId = R.drawable.img_summit, rating = 4.0, location = "부산")
        )
        bandAdapter = BandAdapter(recentBands) { band ->
            // 클릭된 밴드의 상세 정보를 보여주기 위한 코드 작성
        }
        recentBandsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recentBandsRecyclerView.adapter = bandAdapter

        // BottomNavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_profile

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
}
