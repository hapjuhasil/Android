package com.example.happle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.EventsAdapter
import com.example.happle.model.Event
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener

class CalendarActivity : AppCompatActivity() {

    private lateinit var calendarView: MaterialCalendarView
    private lateinit var eventsList: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        eventsList = findViewById(R.id.eventsList)

        eventsAdapter = EventsAdapter()
        eventsList.layoutManager = LinearLayoutManager(this)
        eventsList.adapter = eventsAdapter

        calendarView.setOnDateChangedListener(OnDateSelectedListener { widget, date, selected ->
            // 날짜 선택시 이벤트 목록 갱신
            loadEventsForDate(date)
        })

        calendarView.setOnMonthChangedListener(OnMonthChangedListener { widget, date ->
            // 월 변경시 이벤트 목록 갱신
            loadEventsForMonth(date)
        })

        // 초기 이벤트 로드
        loadEventsForDate(CalendarDay.today())
    }

    private fun loadEventsForDate(date: CalendarDay) {
        // 선택한 날짜의 이벤트를 불러오는 로직
        val events = listOf(
            Event("승식대 써밋", "홍대 OI 씨어터", "18:00"),
            Event("각국대 써마", "명동 GRAP", "21:00")
        )
        eventsAdapter.submitList(events)
    }

    private fun loadEventsForMonth(date: CalendarDay) {
        // 선택한 월의 이벤트를 불러오는 로직
    }
}
