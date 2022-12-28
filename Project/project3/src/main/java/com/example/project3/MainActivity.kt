package com.example.project3

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.project3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goInputActivity.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        binding.deleteButton.setOnClickListener {
            deleteDate()
        }

        binding.numberValueTextViewLayout.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) {
                val phoneNumber = binding.numberValueTextView.text.toString()
                    .replace("-", " ")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDataUiUpdate()
    }

    private fun getDataUiUpdate() {
        getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).apply {
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.birthdayValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodValueTextView.text = getString(BLOOD_TYPE, "미정")

            val warning = getString(WARNING, "")
            binding.cautionValueTextView.isVisible = warning.isNullOrEmpty().not()
            binding.cautionTextView.isVisible = warning.isNullOrEmpty().not()
            binding.cautionValueTextView.text = if (!warning.isNullOrEmpty()) warning else ""


            binding.numberValueTextView.text = getString(EMERGENCY_CONTACT, "미정")

        }
    }

    private fun deleteDate() {
        getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit().apply {
            //파일에 있는 모든 데이터를 삭제
            clear()
            apply()
            getDataUiUpdate()
        }
        Toast.makeText(this, "초기화를 완료했습니다.", Toast.LENGTH_SHORT).show()

    }
}