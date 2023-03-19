package com.example.chap40

import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var customerCount by mutableStateOf(0)

    fun increaseCount(){
        customerCount++
    }

    //LiveData 사용 코드
    var customerName : MutableLiveData<String> = MutableLiveData("")
    fun setName(name : String){
        customerName.value = name
    }
}