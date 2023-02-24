package com.example.chatapp.userlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.Key.Companion.DB_CHAT_ROOMS
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentChatlistBinding
import com.example.chatapp.databinding.FragmentUserlistBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

        val curruntUserId = Firebase.auth.currentUser?.uid ?: return
        val chatRoomsDB = Firebase.database.reference.child(DB_CHAT_ROOMS).child(curruntUserId)

        chatRoomsDB.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val chatRoomList = snapshot.children.map {
                    it.getValue(ChatListItem::class.java)
                }

                chatListAdapter.submitList(chatRoomList)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}