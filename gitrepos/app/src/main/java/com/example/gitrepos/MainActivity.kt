package com.example.gitrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitrepos.adapter.UserAdapter
import com.example.gitrepos.databinding.ActivityMainBinding
import com.example.gitrepos.model.Repo
import com.example.gitrepos.model.User
import com.example.gitrepos.model.UserDto
import com.example.gitrepos.network.GithubService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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


        val userAdapter = UserAdapter()

        binding.userRecyclerView.apply {
            //여기서 컨텍스트는 RecyclerView의 Context
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }


        githubService.searchUsers("squar").enqueue(object : Callback<UserDto> {
            override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                Log.e("MainActivity", "Search : ${response.body().toString()}")

                userAdapter.submitList(response.body()?.items)
            }

            override fun onFailure(call: Call<UserDto>, t: Throwable) {

            }
        })
    }
}