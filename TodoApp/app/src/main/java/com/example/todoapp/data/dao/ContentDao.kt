package com.example.todoapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoapp.model.ContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : ContentEntity)

    @Query("SELECT * FROM Content")
    fun selectAll() : Flow<List<ContentEntity>>

    @Delete
    suspend fun delete(item : ContentEntity)
}