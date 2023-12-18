package com.boostcamp.shoppingapp.di

import com.boostcamp.shoppingapp.remote.MainService
import com.boostcamp.shoppingapp.remote.repository.MainRepository
import com.boostcamp.shoppingapp.remote.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainRepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesMainRepository(
        mainService: MainService
    ): MainRepository = MainRepositoryImpl(mainService)

}