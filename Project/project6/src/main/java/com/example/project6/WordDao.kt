package com.example.project6

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WordDao{
    @Query("SELECT * from word ORDER BY id DESC")
    fun getAll() : List<Word>

    @Query("SELECT * from word ORDER BY id DESC LIMIT 1")
    fun getLatesWord() : Word

    @Insert
    fun insert(word: Word)

    @Delete
    fun delete(word: Word)

    @Update
    fun update(word: Word)
}