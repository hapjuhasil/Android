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

        // 더미 데이터 추가
        val notifications = List(20) {
            Notification("팔로우한 밴드 공지", "18시간 전", "써밋")
        } + Notification("팔로우한 밴드 공지", "18시간 전", "써밋")

        recyclerView.adapter = NotificationAdapter(notifications)
    }
}
