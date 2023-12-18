package com.boostcamp.shoppingapp.di

import com.boostcamp.shoppingapp.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainServiceModule {

    @Provides
    @Singleton
    fun providesMainService(retrofit: Retrofit) = retrofit.create(MainService::class.java)

}