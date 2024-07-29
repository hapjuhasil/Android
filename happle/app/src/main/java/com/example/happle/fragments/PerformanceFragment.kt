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

class PerformanceFragment : Fragment() {

    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_performance, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        eventsAdapter = EventsAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventsAdapter

        // 더미 데이터
        val events = listOf(
            Event("홍대 001 공연", "공연 장소", "18:00", GregorianCalendar(2024, Calendar.JULY, 14).time)
        )

        eventsAdapter.submitList(events)

        return view
    }
}
