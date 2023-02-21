package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val currentUser = Firebase.auth.currentUser

        if(currentUser == null){
            //로그인이 안되어 있음, 로그인 액티비티를 실행한다.
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}