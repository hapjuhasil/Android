package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val btnNext: Button = findViewById(R.id.btn_next) // btn_next 버튼을 찾아서 초기화

        btnNext.setOnClickListener {
            // 다음 페이지로 이동
            val intent = Intent(this, PartSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
