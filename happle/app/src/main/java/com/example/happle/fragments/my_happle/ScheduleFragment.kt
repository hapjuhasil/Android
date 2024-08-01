package com.example.happle.fragments.my_happle

import android.icu.text.SimpleDateFormat
import android.net.ParseException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.R
import com.example.happle.model.Event
import com.example.happle.adapters.EventsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.EditText

class ScheduleFragment : Fragment() {

    private lateinit var eventsAdapter: EventsAdapter
    private val events = mutableListOf<Event>() // 리스트를 변경 가능하게 설정

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val fab: FloatingActionButton = view.findViewById(R.id.fab)

        // 더미 데이터 추가
        events.addAll(listOf(
            Event("홍대 001 공연", "공연", "2024-07-14", GregorianCalendar(2024, Calendar.JULY, 14).time),
            Event("공연 전 마지막 연습", "연습", "2024-07-14", GregorianCalendar(2024, Calendar.JULY, 14).time),
            Event("공연 하루 전!!", "연습", "2024-07-13", GregorianCalendar(2024, Calendar.JULY, 13).time),
            Event("공연 이틀 전 연습 영상", "연습", "2024-07-12", GregorianCalendar(2024, Calendar.JULY, 12).time)
        ))

        // 이벤트 리스트를 어댑터에 전달
        eventsAdapter = EventsAdapter(events)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventsAdapter

        // FAB 클릭 이벤트 설정
        fab.setOnClickListener {
            showAddEventDialog()
        }

        return view
    }

    private fun showAddEventDialog() {
        // 다이얼로그 레이아웃 설정
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_event, null)
        val eventNameInput: EditText = dialogView.findViewById(R.id.eventNameInput)
        val eventTypeInput: EditText = dialogView.findViewById(R.id.eventTypeInput)
        val eventDateInput: EditText = dialogView.findViewById(R.id.eventDateInput)
        val cancelButton: Button = dialogView.findViewById(R.id.cancel_button)
        val saveButton: Button = dialogView.findViewById(R.id.save_button)

        // 다이얼로그 생성 및 표시
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(dialogView)
            .create()

        // 취소 버튼 클릭 리스너
        cancelButton.setOnClickListener {
            dialog.dismiss()  // 다이얼로그를 닫음
        }

        // 저장 버튼 클릭 리스너
        saveButton.setOnClickListener {
            val name = eventNameInput.text.toString()
            val type = eventTypeInput.text.toString()
            val date = eventDateInput.text.toString()

            // 이벤트 추가
            addEvent(name, type, date)

            dialog.dismiss()  // 다이얼로그를 닫음
        }

        dialog.show()
    }



    private fun addEvent(name: String, type: String, date: String) {
        // Date 변환 로직 (date 문자열을 Date 객체로 변환)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val eventDate: Date = try {
            format.parse(date) ?: Date() // date 문자열이 유효하지 않으면 현재 날짜 사용
        } catch (e: ParseException) {
            e.printStackTrace()
            Date() // 오류 발생 시 현재 날짜 사용
        }

        // 새로운 이벤트 객체 생성
        val newEvent = Event(name, type, date, eventDate)

        // 이벤트 리스트에 추가
        events.add(newEvent)
        eventsAdapter.notifyItemInserted(events.size - 1)
        // 추가: 캘린더 업데이트 로직 필요
    }
}
