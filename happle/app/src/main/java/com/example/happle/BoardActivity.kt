package com.example.happle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.BoardPostAdapter
import com.example.happle.model.BoardPost
import com.google.android.material.bottomnavigation.BottomNavigationView

class BoardActivity : AppCompatActivity() {

    private lateinit var boardPostAdapter: BoardPostAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        // 더미 데이터 설정
        // 더미 데이터 설정
        val boardPosts = listOf(
            BoardPost("밴드 입문하려면?", "악기 하나도 못 다루는데 밴드에 들어가고 싶어요. 무엇부터 시작해야 할까요?", "03:45 | 익명"),
            BoardPost("기타 연습곡 추천해주세요", "아마추어 밴드에 들어가고 싶어서 기타를 연습 중입니다. 초보자에게 좋은 연습곡 있을까요?", "03:30 | 익명"),
            BoardPost("밴드 멤버 구하는 방법?", "동네에서 밴드 만들어보려고 하는데 멤버는 어디서 구하면 좋을까요?", "03:20 | 익명"),
            BoardPost("보컬 오디션 준비 방법", "아마추어 밴드 보컬 오디션 보려고 합니다. 어떤 준비를 해야 할까요?", "03:10 | 익명"),
            BoardPost("밴드 연습실 대여 정보", "밴드 연습할 수 있는 공간을 찾고 있어요. 서울에서 저렴한 연습실 추천 부탁드립니다.", "03:00 | 익명"),
            BoardPost("드럼 배우기 시작하려면?", "드럼을 처음 배우려는데 어떤 드럼 세트가 초보자에게 좋을까요?", "02:50 | 익명"),
            BoardPost("밴드 공연 기획하기", "첫 공연을 기획 중인데, 무대 구성과 음향 장비 관련 팁이 있나요?", "02:35 | 익명"),
            BoardPost("베이스 기타의 매력?", "밴드에서 베이스 기타의 역할이 궁금합니다. 왜 베이스를 선택하셨나요?", "02:20 | 익명"),
            BoardPost("밴드와 악기 관리", "밴드를 하면서 악기 관리는 어떻게 하나요? 팁이나 조언 부탁드립니다.", "02:10 | 익명"),
            BoardPost("밴드 활동과 학교 생활", "밴드 활동과 학업을 병행하는 법, 시간 관리 방법이 궁금합니다.", "02:00 | 익명")
        )


        // RecyclerView 및 Adapter 설정
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        boardPostAdapter = BoardPostAdapter(boardPosts)
        recyclerView.adapter = boardPostAdapter

        // BottomNavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_profile

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_calendar -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_my_happle -> {
                    val intent = Intent(this, MyBandsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_board -> {
                    val intent = Intent(this, BoardActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
