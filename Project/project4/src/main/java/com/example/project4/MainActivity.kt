package com.example.project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.project4.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.text.Format

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val firstNumberText = StringBuilder("")
    private val secondNumberText = StringBuilder("")
    private val operationText =StringBuilder("")
    private val decimalFormat = DecimalFormat("#,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    fun numberClicked(view : View){
        val numberString = (view as? Button)?.text.toString() ?: ""
        val numberText = if(operationText.isEmpty()) firstNumberText else secondNumberText

        numberText.append(numberString)
        updateEquationTextView()
    }

    fun clearClicked(view: View){
        firstNumberText.clear()
        operationText.clear()
        secondNumberText.clear()

        updateEquationTextView()
        binding.resultTextView.text = ""
    }

    fun equalClicked(view: View){
        if(firstNumberText.isEmpty() || secondNumberText.isEmpty() || operationText.isEmpty()){
            Toast.makeText(this, "올바르지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
            return
        }

        val firstNumber = firstNumberText.toString().toBigDecimal()
        val secondNumber = secondNumberText.toString().toBigDecimal()

        val result = when(operationText.toString()){
            "+" -> decimalFormat.format(firstNumber + secondNumber)
            "-" -> decimalFormat.format(firstNumber - secondNumber)
            else -> "잘못된 수식입니다."
        }.toString()

        firstNumberText.clear()
        operationText.clear()
        secondNumberText.clear()
        binding.resultTextView.text = result

    }

    fun operatorClicked(view: View){
        val operatorString = (view as? Button)?.text.toString() ?: ""

        if(binding.resultTextView.text.toString().isNotEmpty()){
            if(firstNumberText.isEmpty()){
                val result = binding.resultTextView.text.toString().replace(",","")
                firstNumberText.append(result.toBigDecimal().toString())
                binding.resultTextView.text=""
            }
        }

        if(firstNumberText.isEmpty()){
            Toast.makeText(this, "먼저 숫자를 입력해 주세요", Toast.LENGTH_SHORT).show()
            return
        }

        if(secondNumberText.isNotEmpty()){
            Toast.makeText(this, "1개의 연산자에 대해서만 연산이 가능합니다.", Toast.LENGTH_SHORT).show()
            return
        }

        operationText.append(operatorString)
        updateEquationTextView()
    }

    private fun updateEquationTextView(){
        val firstFormattedNumber = if(firstNumberText.isNotEmpty()) decimalFormat.format(firstNumberText.toString().toBigDecimal()) else ""
        val secondFormattedNumber = if(secondNumberText.isNotEmpty()) decimalFormat.format(secondNumberText.toString().toBigDecimal()) else ""

        binding.equationTextView.text = "$firstFormattedNumber $operationText $secondFormattedNumber"
    }
}