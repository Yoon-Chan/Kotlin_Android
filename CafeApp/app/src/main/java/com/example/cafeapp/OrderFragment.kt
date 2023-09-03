package com.example.cafeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeapp.databinding.FragmentOrderBinding
import kotlin.math.abs


class OrderFragment : Fragment(R.layout.fragment_order) {
    private lateinit var binding : FragmentOrderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)

        val menuData = context?.readData("menu.json", Menu::class.java) ?: return

        val menuAdapter = MenuAdapter().apply {
            submitList(menuData.coffee)
        }


        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = menuAdapter
        }

        binding.appbarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            //앱바가 늘어났다 줄어들었을 때의 변화 리스너
            val seekPosition = abs(verticalOffset) / appBarLayout.totalScrollRange.toFloat()
            binding.motionLayout.progress = seekPosition
        }
    }
}