package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PartSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_selection)

         val btnNext: Button = findViewById(R.id.btn_next)
        val exampleImage: ImageView = findViewById(R.id.unselect)


        btnNext.setOnClickListener {
            val intent = Intent(this, PartSelectedActivity::class.java)
            startActivity(intent)
        }

        // 이미지 클릭 시 다음 페이지로 이동
        exampleImage.setOnClickListener {
            val intent = Intent(this, PartSelectedActivity::class.java)
            startActivity(intent)
        }
    }

}
