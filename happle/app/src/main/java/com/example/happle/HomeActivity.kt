package com.example.happle

import android.widget.Button
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.happle.adapters.BandRankingAdapter
import com.example.happle.adapters.ImageSliderAdapter
import com.example.happle.model.Band
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addButton = findViewById<ImageButton>(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, SearchListActivity::class.java)
            startActivity(intent)
        }

        val bandList = listOf(
            Band(1, "써밋", "숭실대학교 IT대학", R.drawable.img_summit, 4.5, "서울"),
            com.example.happle.model.Band(
                2,
                "쏘마",
                "건국대학교 중앙동아리",
                R.drawable.img_summit,
                4.2,
                "서울"
            ),
            com.example.happle.model.Band(3, "에밀레", "서강대학교 에밀레", R.drawable.img_summit, 4.0, "서울")
        )

        val bandRecyclerView = findViewById<RecyclerView>(R.id.bandRankingRecyclerView)
        bandRecyclerView.layoutManager = LinearLayoutManager(this)
        bandRecyclerView.adapter = BandRankingAdapter(bandList)
        // 알림 버튼 클릭 리스너
        val notificationButton: ImageButton = findViewById(R.id.notificationButton)
        notificationButton.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        val viewPager = findViewById<ViewPager2>(R.id.bannerViewPager)
        val tabLayout = findViewById<TabLayout>(R.id.bannerIndicator)

        val images = listOf(R.drawable.sample_image_main, R.drawable.sample_image_main, R.drawable.sample_image_main)
        val adapter = ImageSliderAdapter(images)
        viewPager.adapter = adapter

        // ViewPager2에 여백 추가
        val recyclerView = viewPager.getChildAt(0) as RecyclerView
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                val position = parent.getChildAdapterPosition(view)
                if (position == RecyclerView.NO_POSITION) return

                val offset = 20 // 간격을 원하는 값으로 설정 (픽셀 단위)
                outRect.right = offset
            }
        })

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // 현재 홈이므로 아무 작업도 하지 않음
                    true
                }
                R.id.navigation_calendar -> {
                    // 캘린더 액티비티로 이동
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_my_happle -> {
                    // 마이합플 액티비티로 이동
                    val intent = Intent(this, MyBandsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_board -> {
                    // 게시판 액티비티로 이동
                    val intent = Intent(this, BoardActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    // 내정보 액티비티로 이동
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}