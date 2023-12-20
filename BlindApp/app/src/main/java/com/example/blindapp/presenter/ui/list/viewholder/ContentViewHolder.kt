package com.example.blindapp.presenter.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.blindapp.databinding.ItemContentBinding
import com.example.blindapp.domain.model.Content
import com.example.blindapp.presenter.ui.MainActivity

class ContentViewHolder(
    private val binding: ItemContentBinding,
    private val handler: MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Content) {
        binding.item = item
        binding.handler = handler
    }
}