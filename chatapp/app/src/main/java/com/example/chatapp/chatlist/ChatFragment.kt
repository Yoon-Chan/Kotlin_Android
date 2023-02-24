package com.example.chatapp.userlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentChatlistBinding
import com.example.chatapp.databinding.FragmentUserlistBinding

class ChatFragment : Fragment(R.layout.fragment_chatlist) {

    private lateinit var binding: FragmentChatlistBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatlistBinding.bind(view)


        val chatListAdapter = ChatListAdapter()
        binding.userListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatListAdapter
        }


        chatListAdapter.submitList(
            mutableListOf<UserItem>().apply {
                add(UserItem("11", "22", "33"))
            }
        )
    }

}