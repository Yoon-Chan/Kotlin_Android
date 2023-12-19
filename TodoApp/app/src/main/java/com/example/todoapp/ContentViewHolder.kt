package com.example.todoapp

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemContentBinding
import com.example.todoapp.model.ContentEntity

class ContentViewHolder(
    private val binding: ItemContentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: ContentEntity) {
        binding.item = item

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}