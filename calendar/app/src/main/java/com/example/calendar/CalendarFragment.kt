package com.example.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.calendar.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CalendarFragment(
) : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    val binding get() = _binding!!


    //val viewModel : CalenderViewModel by viewModels()
    lateinit var date : Date
    lateinit var adapter: CalendarAdapter
    var pageIndex = 0
    var listener = OnClickListener {  }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = savedInstanceState?.getInt("PLANJDEBUG", 0)
        pageIndex = index ?: pageIndex
        Log.d("PLANJDEBUG", "CalendarFragment onViewCreated index : $index")

        initView()
        initAdapter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PLANJDEBUG", "CalendarFragment onSaveInstanceState $pageIndex")
        outState.putInt("pageIndex", pageIndex)
        super.onSaveInstanceState(outState)
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    private fun getWeek(day : Int) : List<saveDate>{
        val c = Calendar.getInstance()
        c.time = date
        c.add(Calendar.DATE, 1-day)
        val list = mutableListOf<saveDate>()
        repeat(7){
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH) + 1
            val dayOfMonth = c.get(Calendar.DAY_OF_MONTH)
            c.add(Calendar.DATE, 1)
            list.add(saveDate(year,month, dayOfMonth))
        }

        return list

    }

    fun initView() {
        date = Calendar.getInstance().run {
            add(Calendar.WEEK_OF_MONTH, pageIndex)
            time
        }

        var datetime: String = SimpleDateFormat(
            "yyyy년 MM월",
            Locale.getDefault()
        ).format(date.time)
        binding.calendarYearMonthText.text = datetime
    }

    fun initAdapter(){
        val calendar = Calendar.getInstance()
        calendar.time = date
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        val getArray = getWeek(day)


        adapter = CalendarAdapter(listener)
        binding.calendarView.adapter = adapter
        adapter.submitList(getArray)
    }


}