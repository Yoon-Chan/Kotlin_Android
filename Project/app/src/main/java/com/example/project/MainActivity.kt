package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var number : Int = 0
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.resetBtn.setOnClickListener {
            number = 0
            binding.numberTextView.text = number.toString()
            Log.i("onClick", "숫자는 $number")
        }

        binding.plusBtn.setOnClickListener {
            number += 1
            binding.numberTextView.text = number.toString()
            Log.d("onClick", "플러스 된 숫자는 $number")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("onSave", number.toString())
        outState.putInt("number", number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt("number")
        binding.numberTextView.text = number.toString()
        Log.d("onRestore", number.toString())
    }

}