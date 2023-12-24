package com.example.securityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.securityapp.databinding.ActivityVerifyOtpBinding

class VerifyOtpActivity : AppCompatActivity() {
    private lateinit var binding : ActivityVerifyOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this

    }
}