package com.example.blindapp.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blindapp.domain.model.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(): ViewModel() {

    private val _doneEvent = MutableLiveData<Pair<Boolean, String>>()
    val doneEvent : LiveData<Pair<Boolean,String>> = _doneEvent

    val category = MutableLiveData("")
    val title = MutableLiveData("")
    val content = MutableLiveData("")
    private var item : Content? = null

    fun initData(item : Content){
        this.item = item
        category.value = item.category
        title.value = item.title
        content.value = item.content
    }

    fun insertData(){
        val categoryValue = category.value
        val titleValue = title.value
        val contentValue = content.value
        if(categoryValue.isNullOrBlank() ||
            titleValue.isNullOrBlank() ||
            contentValue.isNullOrBlank()) {
            _doneEvent.value = Pair(false, "모든 항목을 입력하셔야 합니다.")
            return
        }

        //api 통신

    }
}