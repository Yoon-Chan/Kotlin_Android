package com.example.calendar


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.Date


class CalendarAdapter(private val onClickListener: OnClickListener) : ListAdapter<saveDate,CalendarAdapterViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: CalendarAdapterViewHolder, position: Int) {
        holder.onBind(currentList[position], onClickListener )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAdapterViewHolder {
        return CalendarAdapterViewHolder.from(parent)
    }


    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<saveDate>() {
            override fun areContentsTheSame(oldItem: saveDate, newItem: saveDate): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: saveDate, newItem: saveDate): Boolean {
                return oldItem.day == newItem.day
            }
        }
    }

}