package com.example.blindapp.presenter.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blindapp.databinding.ActivityMainBinding
import com.example.blindapp.domain.model.Content
import com.example.blindapp.presenter.ui.list.ContentListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { ContentListAdapter(Handler()) }
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
    }

    fun onClickAdd() {
        InputActivity.start(this)
    }

    inner class Handler {
        fun onClickItem(item: Content) {
            InputActivity.start(this@MainActivity, item)
        }

        fun onLongClick(item: Content): Boolean {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("정말 삭제하시겠습니까?")
                .setPositiveButton("네") { _, _ ->

                }
                .setNegativeButton("아니요") { _, _ ->

                }.show()

            return false
        }


    }
}