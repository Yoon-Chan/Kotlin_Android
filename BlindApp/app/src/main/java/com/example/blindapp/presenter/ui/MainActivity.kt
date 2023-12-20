package com.example.blindapp.presenter.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blindapp.databinding.ActivityMainBinding
import com.example.blindapp.domain.model.Content
import com.example.blindapp.presenter.ui.list.ContentListAdapter
import com.example.blindapp.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { ContentListAdapter(Handler()) }
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.view = this
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
        observeViewModel()
    }

    fun onClickAdd() {
        InputActivity.start(this)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.contentList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    binding.apply {
                        progressBar.isVisible = false
                        emptyTextView.isVisible = it.isEmpty()
                        recyclerView.isVisible = it.isNotEmpty()
                    }
                    adapter.submitList(it)
                }
        }

        viewModel.doneEvent.observe(this) {
            if (it.first) {
                Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class Handler {
        fun onClickItem(item: Content) {
            InputActivity.start(this@MainActivity, item)
        }

        fun onLongClick(item: Content): Boolean {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("정말 삭제하시겠습니까?")
                .setPositiveButton("네") { _, _ ->
                    viewModel.deleteItem(item)
                }
                .setNegativeButton("아니요") { _, _ ->

                }.show()

            return false
        }


    }
}