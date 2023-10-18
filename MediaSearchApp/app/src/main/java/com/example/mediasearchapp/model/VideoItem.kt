package com.example.mediasearchapp.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class VideoListResponse(
    val document : List<VideoItem>
)


data class VideoItem(
    @SerializedName("thumbnail") override val thumbnaillUrl: String,
    @SerializedName("title") val title: String,
    @SerializedName("play_time") val playTime: Int,
    @SerializedName("author") val author: String,
    @SerializedName("datetime") override val dateTime: Date,
    override val isFavorite: Boolean
) : ListItem