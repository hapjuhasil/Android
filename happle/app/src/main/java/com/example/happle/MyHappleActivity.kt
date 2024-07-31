package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyHappleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_happle)

        // 툴바 설정
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) // 기본 제목 비활성화

        // 뒤로가기 버튼 설정
        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        // 공유 버튼 설정 (옵션)
        val shareButton: ImageView = findViewById(R.id.shareButton)
        shareButton.setOnClickListener {
            // 공유 버튼 클릭 시 동작
        }

        // 멤버 신청 버튼 설정
        val applyButton: Button = findViewById(R.id.applyButton)
        applyButton.setOnClickListener {
            // 멤버 신청하기 버튼 클릭 시 동작
        }

        // 밴드 이미지 클릭 시 동작 설정
        val navigateToPracticeList: ImageView = findViewById(R.id.bandImage)
        navigateToPracticeList.setOnClickListener {
            val intent = Intent(this, BandPracticeListActivity::class.java)
            startActivity(intent)
        }

        // BottomNavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 현재 선택된 아이템을 "마이합플"로 설정
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
}
