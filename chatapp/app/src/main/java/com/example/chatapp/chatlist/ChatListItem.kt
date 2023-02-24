package com.example.chatapp.userlist

data class ChatListItem(
    val userId: String? = null,
    val otherUserName: String? = null,
    val lastMessage: String? = null,
    val otherUserId: String? = null
)