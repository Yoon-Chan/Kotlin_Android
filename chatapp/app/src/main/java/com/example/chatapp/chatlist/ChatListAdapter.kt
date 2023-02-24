package com.example.chatapp.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ItemChatroomBinding
import com.example.chatapp.databinding.ItemUserBinding

class ChatListAdapter : ListAdapter<UserItem, ChatListAdapter.ViewHolder >(diff) {
    inner class ViewHolder(private val binding : ItemChatroomBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: UserItem){
            binding.nicknameTextView.text = item.username
            binding.descriptionTextView.text = item.decription
        }
    }


    companion object{
        val diff = object : DiffUtil.ItemCallback<UserItem>(){
            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
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