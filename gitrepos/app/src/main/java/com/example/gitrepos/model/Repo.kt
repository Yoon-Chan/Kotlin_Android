package com.example.gitrepos.model

import com.google.gson.annotations.SerializedName

data class Repo(
    //id와 매핑을 한다.
    @SerializedName("id")
    val id : Long,

    @SerializedName("name")
    val name : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("language")
    val language : String?,

    @SerializedName("stargazers_count")
    val stargazers_count : Int,

    @SerializedName("forks_count")
    val forks_count : Int,

    @SerializedName("html_url")
    val htmlUrl : String,
)
