package com.example.mediasearchapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mediasearchapp.databinding.ItemImageBinding
import com.example.mediasearchapp.databinding.ItemVideoBinding
import com.example.mediasearchapp.list.viewholder.ImageViewHolder
import com.example.mediasearchapp.list.viewholder.VideoViewHolder
import com.example.mediasearchapp.model.ImageItem
import com.example.mediasearchapp.model.ListItem

class ListAdapter() : ListAdapter<ListItem, RecyclerView.ViewHolder>(diffUtil) {

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ImageItem) {
            IMAGE
        } else {
            VIDEO
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (getItemViewType(position) == IMAGE) {
            (holder as ImageViewHolder).bind(item)
        } else {
            (holder as VideoViewHolder).bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == IMAGE) ImageViewHolder(
            ItemImageBinding.inflate(
                inflater,
                parent,
                false
            )
        )
        else {
            VideoViewHolder(ItemVideoBinding.inflate(inflater, parent, false))
        }
    }


    companion object {
        private const val IMAGE = 0
        private const val VIDEO = 1

        val diffUtil = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem.thumbnaillUrl == newItem.thumbnaillUrl
            }

            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem === newItem
            }
        }
    }
}