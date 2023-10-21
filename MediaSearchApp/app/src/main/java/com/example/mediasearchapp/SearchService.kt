package com.example.mediasearchapp

import io.reactivex.rxjava3.core.Observable
import com.example.mediasearchapp.Utils.API_KEY
import com.example.mediasearchapp.model.ImageListResponse
import com.example.mediasearchapp.model.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("image")
    fun searchImage(
        @Query("query") query: String
    ): Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("vclip")
    fun searchVideo(
        @Query("query") query: String
    ): Observable<VideoListResponse>
}