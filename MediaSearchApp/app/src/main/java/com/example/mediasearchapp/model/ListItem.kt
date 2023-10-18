package com.example.mediasearchapp.model

import java.util.Date

interface ListItem {
    val thumbnaillUrl: String
    val dateTime: Date
    val isFavorite : Boolean
}