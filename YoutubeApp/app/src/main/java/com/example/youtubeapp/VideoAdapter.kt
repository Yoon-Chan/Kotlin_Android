package com.example.youtubeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapp.databinding.ItemVideoBinding

class VideoAdapter(private val context: Context, private val onClick: (VideoEntity) -> Unit) :
    ListAdapter<VideoEntity, VideoAdapter.ViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )
    }

    inner class ViewHolder(private val binding: ItemVideoBinding, private val onClick: (VideoEntity) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: VideoEntity) {
            binding.titleTextView.text = item.title
            binding.subTitleTextView.text =
                context.getString(R.string.sub_title, item.title, item.viewCount, item.dateText)

            Glide.with(binding.root)
                .load(item.videoThumb)
                .into(binding.videoThumbnailImageView)


            Glide.with(binding.root)
                .load(item.channelThumb)
                .circleCrop()
                .into(binding.channelLogImageView)

            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<VideoEntity>() {
            override fun areItemsTheSame(oldItem: VideoEntity, newItem: VideoEntity): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: VideoEntity, newItem: VideoEntity): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}