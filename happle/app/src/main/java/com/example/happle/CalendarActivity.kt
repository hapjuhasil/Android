package com.example.happle

import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happle.adapters.EventsAdapter
import com.example.happle.model.Event
import java.util.*

class CalendarActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var recyclerView: RecyclerView
    private val events = listOf(
        Event("공연 1", "홍대", "18:00", Calendar.getInstance().apply { set(2024, 6, 14) }.time), // 2024년 7월 14일
        Event("공연 2", "강남", "20:00", Calendar.getInstance().apply { set(2024, 6, 15) }.time), // 2024년 7월 15일
        Event("공연 3", "신촌", "19:00", Calendar.getInstance().apply { set(2024, 6, 16) }.time)  // 2024년 7월 16일
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance().apply { set(year, month, dayOfMonth) }.time
            val filteredEvents = events.filter { event -> isSameDay(event.date, selectedDate) }
            if (filteredEvents.isNotEmpty()) {
                recyclerView.adapter = EventsAdapter(filteredEvents)
            } else {
                Toast.makeText(this, "No events for selected date", Toast.LENGTH_SHORT).show()
                recyclerView.adapter = EventsAdapter(emptyList())
            }
        }
    }

    private fun isSameDay(date1: Date, date2: Date): Boolean {
        val calendar1 = Calendar.getInstance().apply { time = date1 }
        val calendar2 = Calendar.getInstance().apply { time = date2 }
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
                calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR)
    }
}
