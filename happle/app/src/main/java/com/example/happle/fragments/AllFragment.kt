package com.example.happle.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.Event
import com.example.happle.adapters.EventsAdapter
import java.util.*

class AllFragment : Fragment() {

    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        eventsAdapter = EventsAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventsAdapter

        // 더미 데이터
        val events = listOf(
            Event("홍대 001 공연", "공연 장소", "18:00", GregorianCalendar(2024, Calendar.JULY, 14).time),
            Event("공연 전 마지막 연습", "연습 장소", "17:00", GregorianCalendar(2024, Calendar.JULY, 14).time),
            Event("공연 하루 전!!", "연습 장소", "16:00", GregorianCalendar(2024, Calendar.JULY, 13).time),
            Event("공연 이틀 전 연습 영상", "연습 장소", "15:00", GregorianCalendar(2024, Calendar.JULY, 12).time)
        )

        eventsAdapter.submitList(events)

        return view
    }
}
