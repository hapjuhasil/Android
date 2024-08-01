package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LoadingSplashActivity : AppCompatActivity() {

    private val SPLASH_DURATION: Long = 2000 // 스플래시 화면을 보여줄 시간 (2초)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_loading)

        Handler().postDelayed({
            // 스플래시 화면이 끝나면 MainActivity로 이동
            startActivity(Intent(this, MainActivity::class.java))
            finish() // 스플래시 화면이 끝나면 종료하여 뒤로 가기 버튼으로 돌아올 수 없도록 함
        }, SPLASH_DURATION)
    }
}