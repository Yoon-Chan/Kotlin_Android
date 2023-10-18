package com.example.mediasearchapp.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.mediasearchapp.databinding.ItemImageBinding
import com.example.mediasearchapp.model.ImageItem
import com.example.mediasearchapp.model.ListItem

class ImageViewHolder(private val binding: ItemImageBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(item : ListItem){
            binding.item = item as ImageItem
        }
}