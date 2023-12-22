package com.example.securityapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.securityapp.bindingadapter.PinViewModel
import com.example.securityapp.databinding.ActivityPinBinding

class PinActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPinBinding
    private val viewModel : PinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
    }

}