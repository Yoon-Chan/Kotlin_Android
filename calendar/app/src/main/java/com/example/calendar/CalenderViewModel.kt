package com.example.calendar

import androidx.lifecycle.ViewModel

class CalenderViewModel : ViewModel() {
    var pageIndex = 0
    var listener : OnClickListener = OnClickListener {  }
}