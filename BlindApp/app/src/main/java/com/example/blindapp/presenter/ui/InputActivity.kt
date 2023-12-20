package com.example.blindapp.presenter.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.blindapp.databinding.ActivityInputBinding
import com.example.blindapp.domain.model.Content
import com.example.blindapp.presenter.viewmodel.InputViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    private val viewModel: InputViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val content = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            (intent.getSerializableExtra(ITEM, Content::class.java))
        } else{
            intent.getSerializableExtra(ITEM) as? Content
        }
        content?.let {
            viewModel.initData(it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun observeViewModel() {
        viewModel.doneEvent.observe(this){
            Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
            if(it.first){
                finish()
            }
        }
    }

    companion object {
        private const val ITEM = "item"

        fun start(context: Context, item : Content? = null){
            Intent(context, InputActivity::class.java).apply {
                putExtra(ITEM, item)
            }.run {
                context.startActivity(this)
            }
        }
    }
}