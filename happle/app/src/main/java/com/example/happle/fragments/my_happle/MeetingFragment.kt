package com.example.happle.fragments.my_happle

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.adapters.ShowAdapter
import com.example.happle.CustomDividerItemDecoration
import com.example.happle.UploadActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MeetingFragment : Fragment() {

    private lateinit var eventsAdapter: ShowAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meeting, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val fab: FloatingActionButton = view.findViewById(R.id.fab)

        val events = listOf(
            Show(R.drawable.img_show_01, "공연", "홍대 001 공연", "7/14 (일)"),
            Show(R.drawable.img_show_02, "연습", "공연 전 마지막 연습", "7/14 (일)"),
            Show(R.drawable.img_show_03, "연습", "공연 하루 전!!", "7/13 (토)"),
            Show(R.drawable.img_show_04, "연습", "공연 이틀 전 연습 영상", "7/12 (금)")
        )

        eventsAdapter = ShowAdapter(events)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventsAdapter
        recyclerView.addItemDecoration(CustomDividerItemDecoration(requireContext()))

        // FloatingActionButton 클릭 이벤트 설정
        fab.setOnClickListener {
            val intent = Intent(requireContext(), UploadActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}

data class Show(
    val imgResId: Int,
    val tag: String,
    val title: String,
    val date: String
)