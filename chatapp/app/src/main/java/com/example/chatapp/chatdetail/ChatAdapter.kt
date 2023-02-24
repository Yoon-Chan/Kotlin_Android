package com.example.chatapp.chatdetail


import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ItemChatBinding
import com.example.chatapp.databinding.ItemChatroomBinding
import com.example.chatapp.databinding.ItemUserBinding
import com.example.chatapp.userlist.ChatListItem
import com.example.chatapp.userlist.UserItem

class ChatAdapter : ListAdapter<ChatItem, ChatAdapter.ViewHolder >(diff) {

    var otherUserItem : UserItem? = null

    inner class ViewHolder(private val binding : ItemChatBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ChatItem){
            if(item.userId == otherUserItem?.userId){
                //상대방이 보낸 것
                binding.usernameTextView.isVisible = true
                binding.usernameTextView.text = otherUserItem?.username //item.userId
                binding.messageTextView.text = item.message
                binding.messageTextView.gravity = Gravity.START
            }else{
                binding.usernameTextView.isVisible = false
                binding.usernameTextView.text = "밖에서 넣어주기" //item.userId
                binding.messageTextView.text = item.message
                binding.messageTextView.gravity = Gravity.START
            }

        }
    }


    companion object{
        val diff = object : DiffUtil.ItemCallback<ChatItem>(){
            override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem.chatId == newItem.chatId
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemChatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}