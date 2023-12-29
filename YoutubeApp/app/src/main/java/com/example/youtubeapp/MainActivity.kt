package com.example.youtubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapp.Util.readData
import com.example.youtubeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoAdapter = VideoAdapter(this) {videoItem ->
            binding.motionLayout.setTransition(R.id.collapse, R.id.expand)
            binding.motionLayout.transitionToEnd()
        }
        binding.motionLayout.jumpToState(R.id.collapse)

        binding.videoListRecyclerView.adapter = videoAdapter

        val videoList = readData("videos.json", VideoList::class.java) ?: VideoList(
            emptyList()
        )
        videoAdapter.submitList(videoList.videos)


    }
}