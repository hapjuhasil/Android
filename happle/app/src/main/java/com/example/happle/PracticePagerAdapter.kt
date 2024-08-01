package com.example.happle

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.happle.fragments.*
import com.example.happle.fragments.my_happle.AllFragment
import com.example.happle.fragments.my_happle.ScheduleFragment
import com.example.happle.fragments.my_happle.MeetingFragment
import com.example.happle.fragments.my_happle.FeedFragment

class PracticePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int) = when (position) {
        0 -> AllFragment()
        1 -> PracticeFragment()
        2 -> FeedFragment()
        3 -> MeetingFragment()
        4 -> ScheduleFragment()
        else -> AllFragment()
    }
}
