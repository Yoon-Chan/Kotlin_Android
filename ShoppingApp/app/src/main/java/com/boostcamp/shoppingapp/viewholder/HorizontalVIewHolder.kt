package com.boostcamp.shoppingapp.viewholder

import com.boostcamp.shoppingapp.ListAdapter
import com.boostcamp.shoppingapp.databinding.ItemHorizontalBinding
import com.boostcamp.shoppingapp.model.Horizontal
import com.boostcamp.shoppingapp.model.ListItem

class HorizontalVIewHolder(
    private val binding : ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}