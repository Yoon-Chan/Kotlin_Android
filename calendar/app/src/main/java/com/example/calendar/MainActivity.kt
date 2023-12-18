package com.example.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.calendar.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initView()
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        val onClickListener = OnClickListener {
            Toast.makeText(this, "클릭한 날짜는 ${it} 입니다.", Toast.LENGTH_SHORT).show()
        }
        val calendarStateAdapter = CalendarFragmentStateAdapter(onClickListener,supportFragmentManager, lifecycle)
        binding.viewPager.adapter = calendarStateAdapter
        binding.viewPager.setCurrentItem(Int.MAX_VALUE / 2, false)

    }


}