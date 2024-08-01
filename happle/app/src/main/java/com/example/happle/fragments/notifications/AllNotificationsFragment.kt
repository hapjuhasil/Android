package com.example.happle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.adapters.NotificationAdapter
import com.example.happle.model.Notification

class AllNotificationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val notifications = listOf(
            Notification("점검 알림: 시스템 점검 예정", "1시간 전", "시스템 관리자"),
            Notification("이벤트: 여름 콘서트 티켓 예매 시작", "2시간 전", "이벤트 팀"),
            Notification("홍보: 최신 앨범 발매 기념", "3시간 전", "홍보 팀"),
            Notification("소식: 밴드 새 멤버 소개", "4시간 전", "밴드 공식 계정"),
            Notification("점검: 서비스 안정성 점검 완료", "5시간 전", "기술 지원팀"),
            Notification("이벤트: 팬미팅 일정 공개", "6시간 전", "이벤트 팀"),
            Notification("홍보: 여름 시즌 한정 굿즈 출시", "7시간 전", "홍보 팀"),
            Notification("소식: 공연장 새로 오픈", "8시간 전", "운영팀"),
            Notification("점검: 웹사이트 업데이트 예정", "9시간 전", "개발팀"),
            Notification("이벤트: 콘서트 VIP 티켓 추첨", "10시간 전", "이벤트 팀"),
            Notification("홍보: 신곡 발표 기념 할인 이벤트", "11시간 전", "홍보 팀"),
            Notification("소식: 새로운 앨범 리뷰 공개", "12시간 전", "밴드 공식 계정"),
            Notification("점검: 서버 점검 완료", "13시간 전", "기술 지원팀"),
            Notification("이벤트: 팬 투표 결과 발표", "14시간 전", "이벤트 팀"),
            Notification("홍보: 굿즈 할인 쿠폰 제공", "15시간 전", "홍보 팀")
        )

        adapter = NotificationAdapter(notifications)
        recyclerView.adapter = adapter
    }
}
