package com.boostcamp.shoppingapp

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.boostcamp.shoppingapp.model.ListItem
import com.boostcamp.shoppingapp.model.ViewHolderGenerator
import com.boostcamp.shoppingapp.viewholder.BindingViewHolder

class PagingListAdapter : PagingDataAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?: -1
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if (item != null)
            holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent, viewType)
    }
}