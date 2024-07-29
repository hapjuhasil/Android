package com.example.happle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MyHappleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_happle)

        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val applyButton: Button = findViewById(R.id.applyButton)
        applyButton.setOnClickListener {
            // 멤버 신청하기 버튼 클릭 시 동작
        }

        val navigateToPracticeList: ImageView = findViewById(R.id.bandImage)
        navigateToPracticeList.setOnClickListener {
            val intent = Intent(this, BandPracticeListActivity::class.java)
            startActivity(intent)
        }
    }
}
