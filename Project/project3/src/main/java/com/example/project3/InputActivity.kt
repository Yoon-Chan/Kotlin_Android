package com.example.project3


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.project3.databinding.InputActivityBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding: InputActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = InputActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_list_item_1
        )


        binding.birthdatelayer.setOnClickListener {
            val listener = OnDateSetListener { _, year, month, dayOfMonth ->
                binding.birthdayValueTextView.text = "$year-${month.inc()}-$dayOfMonth"
            }
            DatePickerDialog(
                this, listener,
                2000,
                1,
                1
            ).show()
        }

        binding.cautionValueEditText.isVisible = binding.checkBox.isChecked
        binding.checkBox.setOnCheckedChangeListener { _, b ->
            binding.cautionValueEditText.isVisible = b
        }

        binding.saveButton.setOnClickListener {
            saveData()
            finish()
        }
    }


    private fun saveData() {
        getSharedPreferences("userInformation", Context.MODE_PRIVATE).edit().apply {
            putString(NAME, binding.nameValueEditText.text.toString())
            putString(BLOOD_TYPE, getBloodType())
            putString(EMERGENCY_CONTACT, binding.numberValueEditText.text.toString())
            putString(BIRTHDATE, binding.birthdayValueTextView.text.toString())
            putString(WARNING, getwarning())
            commit()
        }
        Toast.makeText(this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType() : String{
        val bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if(binding.bloodTypePlus.isChecked) "+" else "-"
        return "$bloodSign$bloodAlphabet"
    }

    private fun getwarning() = if(binding.checkBox.isChecked) binding.cautionValueEditText.text.toString() else ""

}