package com.example.calendar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.databinding.ItemDayOfWeekBinding
import java.text.SimpleDateFormat
import java.util.Locale

class CalendarAdapterViewHolder(private val binding : ItemDayOfWeekBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item : saveDate, onClickListener: OnClickListener){
        val dayOfWeek = when(adapterPosition){
            0 -> "SUN"
            1 -> "MON"
            2 -> "TUE"
            3 -> "WED"
            4 -> "THU"
            5 -> "FRI"
            6 -> "SAT"
            else -> "NULL"
        }
        binding.tvDayOfWeek.text = dayOfWeek
        binding.tvDay.text = item.day.toString()

        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(System.currentTimeMillis())
        Log.d("ABCDEFG", "${date}/ ${item.year}-${item.month}-${item.day}")
        if(date == "${item.year}-${String.format("%02d", item.month)}-${String.format("%02d", item.day)}"){
            binding.root.setBackgroundResource(R.color.blue)
        }else{
            binding.root.setBackgroundResource(R.color.white)
        }

        itemView.setOnClickListener {
            onClickListener.onClick("${item.year}-${String.format("%02d", item.month)}-${String.format("%02d", item.day)}")
        }
    }


    companion object{
        fun from(parent : ViewGroup) : CalendarAdapterViewHolder {
            return CalendarAdapterViewHolder(
                ItemDayOfWeekBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}