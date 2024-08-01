package com.example.happle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
import com.example.happle.fragments.my_happle.AllFragment
import com.example.happle.fragments.my_happle.ChallengeFragment
import com.example.happle.fragments.my_happle.MeetingFragment
import com.example.happle.fragments.my_happle.PerformanceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyHappleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_happle)

        // 툴바 설정
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // ViewPager2와 TabLayout 설정
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        // ViewPager에 어댑터 설정
        val adapter = ViewPagerAdapter(this)
        adapter.setFragments(listOf(
            MyHappleFragment(),
            ChallengeFragment(),
            MeetingFragment(),
            PerformanceFragment()
        ))
        viewPager.adapter = adapter

        // TabLayout과 ViewPager를 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "전체"
                1 -> "챌린지"
                2 -> "미팅"
                3 -> "공연"
                else -> ""
            }
        }.attach()

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
