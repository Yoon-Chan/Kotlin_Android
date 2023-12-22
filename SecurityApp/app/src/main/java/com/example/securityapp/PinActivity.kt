package com.example.securityapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.securityapp.bindingadapter.PinViewModel
import com.example.securityapp.databinding.ActivityPinBinding
import com.example.securityapp.widget.ShuffleNumberKeyboard

class PinActivity : AppCompatActivity(), ShuffleNumberKeyboard.KeyPadListener {
    private lateinit var binding : ActivityPinBinding
    private val viewModel : PinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.shuffleKeyboard.setKeyPadListener(this)

        viewModel.messageLiveData.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClickNumber(num: String) {
        viewModel.input(num)
    }

    override fun onClickDelete() {
        viewModel.delete()
    }

    override fun onClickDone() {
        viewModel.done()
    }
}