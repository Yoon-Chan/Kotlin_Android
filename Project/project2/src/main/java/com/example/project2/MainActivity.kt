package com.example.project2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.project2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var cmToM = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val inputEditText = binding.inputEditText
        val inputUnitTextView = binding.inputUnitTextView
        val swapImageButton = binding.swapImageButton
        var inputNumber : Double = 0.0
        inputEditText.addTextChangedListener {
            text ->
            inputNumber = if(text.isNullOrEmpty()){
                0.0
            }else
                text.toString().toDouble()

            val outputNumber: Double
            if(cmToM){
                outputNumber = inputNumber*(0.01)
            }else{
                outputNumber = inputNumber*(100.0)
            }

            outputTextView.text = String.format("%.2f", outputNumber)
        }

        swapImageButton.setOnClickListener {
            cmToM = !cmToM
            if(cmToM){
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"

                outputTextView.text = String.format("%.2f", inputNumber*0.01)
            }else
            {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = (inputNumber*100).toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("cmToM", cmToM)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        cmToM = savedInstanceState.getBoolean("cmToM")
        binding.inputUnitTextView.text = if(cmToM) "cm" else "m"
        binding.outputUnitTextView.text = if(cmToM) "m" else "cm"
//        if(cmToM){
//            binding.inputUnitTextView.text = "cm"
//            binding.outputUnitTextView.text = "m"
//        }else{
//            binding.inputUnitTextView.text = "m"
//            binding.outputUnitTextView.text = "cm"
//        }
    }
}