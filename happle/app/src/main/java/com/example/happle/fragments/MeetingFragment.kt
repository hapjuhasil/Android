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

class MeetingFragment : Fragment() {

    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meeting, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        eventsAdapter = EventsAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventsAdapter

        // 더미 데이터
        val events = listOf(
            Event("밴드 미팅", "미팅 장소", "14:00", GregorianCalendar(2024, Calendar.JULY, 15).time)
        )

        eventsAdapter.submitList(events)

        return view
    }
}
