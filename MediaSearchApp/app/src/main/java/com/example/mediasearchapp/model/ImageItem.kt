package com.example.mediasearchapp.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ImageListResponse(
    val document : List<ImageItem>
)



data class ImageItem(
    @SerializedName("thumbnail_url") override val thumbnaillUrl: String,
    @SerializedName("collection") val collection: String,
    @SerializedName("display_sitename") val siteName: String,
    @SerializedName("doc_url") val docUrl: String,
    @SerializedName("datetime") override val dateTime: Date,
    override val isFavorite: Boolean
) : ListItem
