package com.example.blindapp.domain.model

import java.io.Serializable
import java.util.Date

data class Content(
    val id: Int? = null,
    val title: String,
    val content: String,
    val category: String,
    val createDate: Date = Date(),
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val viewCount: Int = 0
) : Serializable
