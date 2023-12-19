package com.example.todoapp.di

import com.example.todoapp.repository.ContentRepository
import com.example.todoapp.repository.ContentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(
        contentRepositoryImpl: ContentRepositoryImpl
    ) : ContentRepository
}