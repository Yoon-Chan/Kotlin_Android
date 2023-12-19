package com.boostcamp.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.boostcamp.shoppingapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { PagingListAdapter() }

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        observeViewModel()
    }


    private fun observeViewModel(){
        lifecycleScope.launch {
            viewModel.pagingData.collectLatest {
                if(it != null){
                    adapter.submitData(lifecycle, it)
                }
            }
        }
    }
}