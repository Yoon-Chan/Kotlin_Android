package com.boostcamp.shoppingapp.viewholder

import com.boostcamp.shoppingapp.ListAdapter
import com.boostcamp.shoppingapp.databinding.ItemViewpagerBinding
import com.boostcamp.shoppingapp.model.ListItem
import com.boostcamp.shoppingapp.model.ViewPager

class ViewPagerViewHolder(
    private val binding : ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding) {

    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }

}