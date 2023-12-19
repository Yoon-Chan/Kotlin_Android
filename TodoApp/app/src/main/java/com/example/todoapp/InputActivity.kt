package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}