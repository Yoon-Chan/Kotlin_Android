package com.example.mediasearchapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import com.example.mediasearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this

        setSupportActionBar(binding.toolbarLayout)
        binding.toolbarLayout.setBackgroundColor(getColor(R.color.primary_color))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                //텍스트가 변경될 때마다 호출하게 된다.
                override fun onQueryTextChange(newText: String): Boolean {

                    return false
                }

                //실제 입력을 하고 입력 완료 버튼을 누를 때
                override fun onQueryTextSubmit(query: String): Boolean {

                    return false
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }
}