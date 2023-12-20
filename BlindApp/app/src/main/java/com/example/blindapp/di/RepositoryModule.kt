package com.example.blindapp.di

import com.example.blindapp.data.repository.ContentRepositoryImpl
import com.example.blindapp.data.source.remote.api.ContentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(
        contentService: ContentService
    ) = ContentRepositoryImpl(contentService)
}