package com.example.chap41

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class DemoViewModel : ViewModel() {

    //섭씨 화씨 판단 여부
    var isFahrenheit by mutableStateOf(true)

    //결과 저장
    var result by mutableStateOf("")

    //화씨 섭씨 변환 함수
    fun convertTemp(temp :String){
        result = try {
            val tempInt = temp.toInt()

            if(isFahrenheit){
                ((tempInt - 32) * 0.5556).roundToInt().toString()
            }else{
                ((tempInt * 1.8) + 32).roundToInt().toString()
            }
        } catch (e : java.lang.Exception){
            "Invalid Entry"
        }
    }

    //섭씨 화씨 판단하는 isFahrenheit 스위치
    fun switchChange(){
        isFahrenheit = !isFahrenheit
    }
}