package com.example.cafeapp

data class Home(
    val user: User,
    val appbarImage: String,
)

data class User(
    val nickName: String,
    val starCount: Int,
    val totalCount: Int,
)