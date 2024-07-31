package com.example.happle

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.example.happle.fragments.AllNotificationsFragment
import com.example.happle.fragments.FollowedBandsNotificationsFragment

class NotificationActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var notificationTitle: TextView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        tabLayout = findViewById(R.id.tabLayout)
        notificationTitle = findViewById(R.id.notificationTitle)
        backButton = findViewById(R.id.backButton)

        // 뒤로가기 버튼 클릭 시 현재 액티비티 종료
        backButton.setOnClickListener {
            onBackPressed()
        }

        // 탭 추가 및 텍스트 설정
        tabLayout.addTab(tabLayout.newTab().setText("전체 공지"))
        tabLayout.addTab(tabLayout.newTab().setText("팔로우한 밴드 공지"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val fragment = when (tab.position) {
                    0 -> AllNotificationsFragment()
                    1 -> FollowedBandsNotificationsFragment()
                    else -> AllNotificationsFragment()
                }
                replaceFragment(fragment)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        // 초기 탭 설정
        tabLayout.getTabAt(0)?.select()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
