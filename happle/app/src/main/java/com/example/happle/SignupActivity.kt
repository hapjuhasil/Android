package com.example.happle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // 중복 확인 버튼과 EditText 가져오기
        val checkDuplicateButton: Button = findViewById(R.id.checkDuplicateButton)
        val idEditText: EditText = findViewById(R.id.idEditText)
        val backButton: ImageView = findViewById(R.id.backButton) // ImageView로 변경

        // 중복 확인 버튼 클릭 리스너 설정
        checkDuplicateButton.setOnClickListener {
            // 무조건 "사용할 수 있습니다" 메시지를 Toast로 표시
            Toast.makeText(this, "사용하실 수 있습니다", Toast.LENGTH_SHORT).show()
        }

        // 뒤로가기 버튼 클릭 리스너 설정
        backButton.setOnClickListener {
            // 로그인 화면으로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // 현재 액티비티 종료
            finish()
        }
    }
}
