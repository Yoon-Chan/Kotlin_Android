package com.example.youtubeapp.player

import com.example.youtubeapp.VideoEntity
import com.google.gson.annotations.SerializedName

data class PlayerVideo(
    override val id: String,
    val title: String,
    val videoUrl: String,
    val channelName: String,
    val viewCount: String,
    val dateText: String,
    val channelThumb: String,
    val videoThumb: String
) : PlayerVideoModel


fun VideoEntity.transform(): PlayerVideo {
    return PlayerVideo(
        id = this.id,
        title = this.title,
        channelName = this.channelName,
        viewCount = this.viewCount,
        channelThumb = this.channelThumb,
        dateText = this.dateText,
        videoThumb = this.videoThumb,
        videoUrl = this.videoUrl
    )
}