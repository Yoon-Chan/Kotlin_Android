package com.example.project8

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener {
            mediaPlayerPlay()
        }

        binding.stopButton.setOnClickListener {
            mediaPlayersttop()
        }

        binding.pauseButton.setOnClickListener {
            mediaPlayerPause()
        }


    }

    private fun mediaPlayerPlay(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply { action = MEDIA_PLAYER_PLAY }
        startService(intent)




//
//        if(mediaPlayer == null){
//            mediaPlayer = MediaPlayer.create(this, R.raw.primetime).apply {
//                isLooping = true
//            }
//            mediaPlayer?.start()
//        }
//
//        mediaPlayer?.start()


    }
    private fun mediaPlayerPause(){

        val intent = Intent(this, MediaPlayerService::class.java)
            .apply { action = MEDIA_PLAYER_PAUSE}
        startService(intent)

    }

    private fun mediaPlayersttop(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply { action = MEDIA_PLAYER_STOP }
        startService(intent)

    }

    override fun onDestroy() {
        stopService(Intent(this, MediaPlayerService::class.java))
        super.onDestroy()
    }
}