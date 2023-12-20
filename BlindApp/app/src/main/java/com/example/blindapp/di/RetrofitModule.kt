package com.example.blindapp.di

import com.example.blindapp.util.DateUtil
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providesConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setDateFormat(DateUtil.serverDateFormat.toPattern())
                .create()
        )
    }

    @Singleton
    @Provides
    fun providesOkHttpClient() : OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            connectTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
    }

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient.Builder, gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.31.16:3030/api/v1/fastcampus/chapter8/")
            .client(client.build())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}