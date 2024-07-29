package com.example.happle

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.happle.fragments.*

class PracticePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int) = when (position) {
        0 -> AllFragment()
        1 -> PracticeFragment()
        2 -> PerformanceFragment()
        3 -> MeetingFragment()
        4 -> ChallengeFragment()
        else -> AllFragment()
    }
}
