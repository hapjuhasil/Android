package com.example.happle.fragments.my_happle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.SearchListActivity
import com.example.happle.model.Event
import com.example.happle.adapters.EventsAdapter
import com.example.happle.adapters.PostAdapter
import com.example.happle.model.Post
import java.util.*

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // 더미 데이터 추가
        val posts = listOf(
            Post("Summit", "1일 전", "안녕하세요, 밴드 Summit입니다! 🎸\n다가오는 공연을 준비하며 새로운 멤버를 모집합니다. 관심 있으신 분들은 문의 주세요!\n\n*모집 분야*: 기타, 베이스, 드럼, 보컬"),
            Post("Summit", "3일 전", "안녕하세요, 밴드 Summit입니다! 이번 주 금요일에 새 앨범 녹음을 시작합니다. 모든 멤버들이 모일 예정이니, 참여 가능한 멤버들은 연락 부탁드립니다."),
            Post("Summit", "1주 전", "Summit의 첫 라이브 스트리밍 콘서트가 다음 주 토요일에 있습니다! 모두 많이 참여해 주세요 🎶\n\n*일시*: 다음 주 토요일 8시\n*장소*: 온라인 스트리밍"),
            Post("Summit", "2주 전", "다음 주에는 연습실 예약이 다 차서 새로운 장소를 찾고 있습니다. 좋은 연습실을 아시는 분들은 댓글로 추천 부탁드립니다!"),
            Post("Summit", "3주 전", "안녕하세요! 새로운 곡 작업을 시작했습니다. 의견이 있으신 분들은 언제든지 공유해 주세요. 여러분의 아이디어가 필요합니다! 💡")
        )


        val adapter = PostAdapter(posts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }
}