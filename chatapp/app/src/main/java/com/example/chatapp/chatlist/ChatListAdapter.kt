package com.example.chatapp.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ItemChatroomBinding
import com.example.chatapp.databinding.ItemUserBinding

class ChatListAdapter : ListAdapter<ChatListItem, ChatListAdapter.ViewHolder >(diff) {
    inner class ViewHolder(private val binding : ItemChatroomBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ChatListItem){
            binding.nicknameTextView.text = item.otherUserName
            binding.descriptionTextView.text = item.lastMessage
        }
    }


    companion object{
        val diff = object : DiffUtil.ItemCallback<ChatListItem>(){
            override fun areContentsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                return oldItem.userId == newItem.userId
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemChatroomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}