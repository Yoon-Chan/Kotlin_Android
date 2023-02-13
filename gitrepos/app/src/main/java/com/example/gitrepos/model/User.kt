package com.example.gitrepos.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val username : String,
    @SerializedName("id")
    val id : Int,
)
