package com.example.todoapp.repository

import com.example.todoapp.model.ContentEntity
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    suspend fun insert(item : ContentEntity)

    fun loadList() : Flow<List<ContentEntity>>
}