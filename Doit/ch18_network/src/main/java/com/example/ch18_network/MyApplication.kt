package com.example.ch18_network

import android.app.Application
import com.android.volley.toolbox.Volley
import com.example.ch18_network.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication : Application() {

    companion object {
        val QUERY = "travel"
        val API_KEY = "ca95462e77304ede947cfb6829c7d8a4"
        val BASE_URL = "https://newsapi.org"
        val USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"


        //add....................................
        var networkService: NetworkService
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        init {
            networkService = retrofit.create(NetworkService::class.java)
        }
    }

}