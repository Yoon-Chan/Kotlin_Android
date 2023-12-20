package com.example.blindapp.di

import com.example.blindapp.data.repository.ContentRepositoryImpl
import com.example.blindapp.data.source.local.dao.ContentDao
import com.example.blindapp.data.source.remote.api.ContentService
import com.example.blindapp.domain.repository.ContentRepository
import com.example.blindapp.domain.usecase.ContentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesContentRepository(
        contentService: ContentService,
        contentDao: ContentDao
    ) : ContentRepository = ContentRepositoryImpl(contentService, contentDao)

}