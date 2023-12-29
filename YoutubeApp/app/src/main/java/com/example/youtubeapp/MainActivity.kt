package com.example.youtubeapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.youtubeapp.Util.readData
import com.example.youtubeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var videoAdapter: VideoAdapter
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initMotionLayout()

        initVideoRecyclerView()


    }

    private fun initVideoRecyclerView() {
        videoAdapter = VideoAdapter(this) { videoItem ->
            binding.motionLayout.setTransition(R.id.collapse, R.id.expand)
            binding.motionLayout.transitionToEnd()
            play(videoItem)
        }
        binding.videoListRecyclerView.adapter = videoAdapter

        val videoList = readData("videos.json", VideoList::class.java) ?: VideoList(
            emptyList()
        )
        videoAdapter.submitList(videoList.videos)
    }

    private fun initMotionLayout() {
        binding.motionLayout.targetView = binding.videoPlayerContainer
        binding.motionLayout.jumpToState(R.id.collapse)
    }

    override fun onStart() {
        super.onStart()
        if(player == null){
            initExoPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if(player == null){
            initExoPlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        player?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }

    private fun initExoPlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .also {exoPlayer ->
                binding.playerView.player = exoPlayer
            }
    }

    private fun play(videoItem: VideoItem){
        player?.setMediaItem(MediaItem.fromUri(Uri.parse(videoItem.videoUrl)))
        player?.prepare()
        player?.play()
    }
}