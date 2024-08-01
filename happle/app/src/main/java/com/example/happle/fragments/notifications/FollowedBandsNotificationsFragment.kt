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

class FollowedBandsNotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_followed_bands_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val notifications = listOf(
        // 소식
        Notification("소식: 밴드 새 멤버 소개", "4시간 전", "밴드 공식 계정"),
        Notification("소식: 공연장 새로 오픈", "8시간 전", "운영팀"),
        Notification("소식: 새로운 앨범 리뷰 공개", "12시간 전", "밴드 공식 계정"),

        // 팔로우한 밴드 소식
        Notification("공연 소식: 밴드 XYZ의 새로운 공연 일정이 추가되었습니다.", "20분 전", "밴드 XYZ"),
        Notification("연습 소식: 밴드 ABC의 연습 세션이 업데이트되었습니다.", "1시간 전", "밴드 ABC"),
        Notification("새 소식: 밴드 DEF의 최근 인터뷰 기사 공개.", "2시간 전", "밴드 DEF"),
        Notification("공연 소식: 밴드 GHI의 공연이 곧 개최됩니다.", "3시간 전", "밴드 GHI"),
        Notification("연습 소식: 밴드 JKL의 새로운 연습 일정이 올라왔습니다.", "4시간 전", "밴드 JKL") , Notification("공연 소식: 밴드 MNO의 신곡 발표 기념 공연이 열립니다.", "30분 전", "밴드 MNO"),
        Notification("연습 소식: 밴드 PQR의 새로운 연습 계획이 업데이트되었습니다.", "2시간 전", "밴드 PQR"),
        Notification("새 소식: 밴드 STU의 앨범 리믹스 버전이 공개되었습니다.", "4시간 전", "밴드 STU"),
        Notification("공연 소식: 밴드 VWX의 야외 공연 일정이 추가되었습니다.", "6시간 전", "밴드 VWX"),
        Notification("연습 소식: 밴드 YZA의 연습 세션 하이라이트가 업로드되었습니다.", "8시간 전", "밴드 YZA")


        )

        recyclerView.adapter = NotificationAdapter(notifications)
    }
}
