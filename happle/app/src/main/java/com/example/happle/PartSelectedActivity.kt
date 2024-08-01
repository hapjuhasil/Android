package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PartSelectedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_selected)

        val btnNext: Button = findViewById(R.id.btn_next)

        btnNext.setOnClickListener {
            val intent = Intent(this, LoadingSplashActivity::class.java)
            startActivity(intent)
        }

    }

}
