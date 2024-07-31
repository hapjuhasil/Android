package com.example.happle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 현재 선택된 아이템을 "게시판"으로 설정
        bottomNavigationView.selectedItemId = R.id.navigation_board

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_calendar -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_my_happle -> {
                    val intent = Intent(this, MyHappleActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_board -> {
                    // 현재 게시판 화면이므로 아무 작업도 하지 않음
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
