package com.example.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Content")
data class ContentEntity(
    @PrimaryKey(true) val id: Int = 0,
    @ColumnInfo val content: String,
    @ColumnInfo val memo: String? = null,
    @ColumnInfo val isDone: Boolean = false
) : Serializable