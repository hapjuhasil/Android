package com.example.happle

import android.content.Intent
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

        // 뒤로가기 버튼 클릭 이벤트 처리
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MyBandsActivity::class.java)
            startActivity(intent)
            finish() // 현재 액티비티를 종료하여 뒤로가기가 아니라 실제 이동으로 보이게 함
        }
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
