package com.example.gitrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gitrepos.model.Repo
import com.example.gitrepos.model.User
import com.example.gitrepos.model.UserDto
import com.example.gitrepos.network.GithubService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //retrofit 빌드
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val githubService = retrofit.create(GithubService::class.java)
        githubService.listRepos("square").enqueue(object : Callback<List<Repo>>{
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.e("MainActivity", "User List : ${response.body().toString()}")
            }
        })

        githubService.searchUsers("squar").enqueue(object : Callback<UserDto> {
            override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                Log.e("MainActivity", "Search : ${response.body().toString()}")
            }

            override fun onFailure(call: Call<UserDto>, t: Throwable) {

            }
        })
    }
}