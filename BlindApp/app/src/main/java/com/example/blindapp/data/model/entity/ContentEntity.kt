package com.example.blindapp.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.Date

@Entity(tableName = "content")
data class ContentEntity(
    @PrimaryKey(false) val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val content: String,
    @ColumnInfo val category: String,
    @ColumnInfo val createDate: Date,
    @ColumnInfo val likCount: Int,
    @ColumnInfo val commentCount: Int,
    @ColumnInfo val viewCount: Int,
) : Serializable
