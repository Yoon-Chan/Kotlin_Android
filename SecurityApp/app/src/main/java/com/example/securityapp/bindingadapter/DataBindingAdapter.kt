package com.example.securityapp.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.securityapp.R

@BindingAdapter(value = ["code_text", "code_index"])
fun ImageView.setPin(code_text: CharSequence, index : Int){
    if(code_text != null){
        if(code_text.length > index){
            setImageResource(R.drawable.baseline_circle_24)
        }else{
            setImageResource(R.drawable.baseline_circle_gray_24)
        }
    }
}