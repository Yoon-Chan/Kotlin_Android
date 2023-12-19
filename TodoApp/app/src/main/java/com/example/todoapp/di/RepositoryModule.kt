package com.example.todoapp.di

import com.example.todoapp.data.dao.ContentDao
import com.example.todoapp.repository.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(
        contentDao: ContentDao
    ) = ContentRepositoryImpl(contentDao)
}