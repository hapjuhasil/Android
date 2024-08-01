package com.example.happle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result) // activity_result.xml을 설정

        val completionButton: Button = findViewById(R.id.completion_button)

        completionButton.setOnClickListener {
            // MyHappleActivity로 이동
            val intent = Intent(this, MyHappleActivity::class.java)
            startActivity(intent)
            finish() // 현재 Activity 종료
        }
    }
}
