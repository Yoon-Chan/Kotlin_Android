package com.example.gitrepos.network

import com.example.gitrepos.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{username}/repos")
    fun listRepo(@Path("username") username : String) : Call<List<Repo>>
}