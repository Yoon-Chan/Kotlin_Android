package com.example.todoapp.di

import com.example.todoapp.data.AppDatabase
import com.example.todoapp.data.dao.ContentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun providesContentDao(database: AppDatabase) : ContentDao {
        return database.contentDao()
    }
}