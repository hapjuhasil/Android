package com.example.happle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
import com.example.happle.fragments.my_happle.*

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
        adapter.setFragments(
            listOf(
                MyHappleFragment(),
                ScheduleFragment(),
                MeetingFragment(),
                FeedFragment()
            )
        )
        viewPager.adapter = adapter

        // TabLayout과 ViewPager를 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "홈"
                1 -> "스케쥴"
                2 -> "활동"
                3 -> "피드"
                else -> ""
            }
        }.attach()
    }
}
