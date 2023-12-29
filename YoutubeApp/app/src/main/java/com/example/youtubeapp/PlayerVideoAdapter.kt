package com.example.youtubeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapp.databinding.ItemHeaderBinding
import com.example.youtubeapp.databinding.ItemVideoBinding
import com.example.youtubeapp.player.PlayerHeader
import com.example.youtubeapp.player.PlayerVideo
import com.example.youtubeapp.player.PlayerVideoModel

class PlayerVideoAdapter(private val context: Context, private val onClick: (PlayerVideo) -> Unit) :
    ListAdapter<PlayerVideoModel, RecyclerView.ViewHolder>(diffUtil) {

    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PlayerHeader) {
            binding.titleTextView.text = item.title
            binding.channelNameTextView.text = item.channelName
            binding.subTitleTextView.text =
                context.getString(R.string.header_sub_title, item.viewCount, item.dateText)

            Glide.with(binding.channelImageView)
                .load(item.channelThumb)
                .circleCrop()
                .into(binding.channelImageView)
        }
    }

    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PlayerVideo) {
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_HEADER) {
            HeaderViewHolder(
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            VideoViewHolder(
                ItemVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_HEADER) {
            (holder as HeaderViewHolder).onBind(currentList[position] as PlayerHeader)
        } else {
            (holder as VideoViewHolder).onBind(currentList[position] as PlayerVideo)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_HEADER
        } else VIEW_TYPE_VIDEO
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_VIDEO = 1
        val diffUtil = object : DiffUtil.ItemCallback<PlayerVideoModel>() {
            override fun areContentsTheSame(
                oldItem: PlayerVideoModel,
                newItem: PlayerVideoModel
            ): Boolean {
                return if (oldItem is PlayerVideo && newItem is PlayerVideo) {
                    oldItem == newItem
                } else if (oldItem is PlayerHeader && newItem is PlayerHeader) {
                    oldItem == newItem
                } else {
                    false
                }
            }

            override fun areItemsTheSame(
                oldItem: PlayerVideoModel,
                newItem: PlayerVideoModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}