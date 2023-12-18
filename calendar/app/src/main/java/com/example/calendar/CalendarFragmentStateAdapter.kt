package com.example.calendar

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CalendarFragmentStateAdapter(private val onClickListener: OnClickListener, fragmentActivity: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentActivity, lifecycle) {

    override fun getItemCount(): Int = Int.MAX_VALUE


    override fun createFragment(position: Int): Fragment {
        Log.d("PLANJDEBUG", "CalendarFragmentStateAdapter createFragment")
        val calendar = CalendarFragment().apply {
            pageIndex = position - Int.MAX_VALUE / 2
            listener = onClickListener
        }
        return calendar
    }


}