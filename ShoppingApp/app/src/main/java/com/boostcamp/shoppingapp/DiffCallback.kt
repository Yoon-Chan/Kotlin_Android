package com.boostcamp.shoppingapp

import androidx.recyclerview.widget.DiffUtil
import com.boostcamp.shoppingapp.model.ListItem

class DiffCallback<T: ListItem> : DiffUtil.ItemCallback<T>() {
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.viewType == newItem.viewType && oldItem.getKey() == newItem.getKey()
    }

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem === newItem
    }
}