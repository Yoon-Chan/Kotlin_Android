package com.example.youtubeapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.youtubeapp.Util.readData
import com.example.youtubeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var playerVideoAdapter: PlayerVideoAdapter
    private var player: ExoPlayer? = null
    private val videoList by lazy {
        readData("videos.json", VideoList::class.java) ?: VideoList(
            emptyList()
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMotionLayout()
        initVideoRecyclerView()
        initPlayerVideoRecyclerView()
        initControl()
        binding.hideButton.setOnClickListener {
            binding.motionLayout.transitionToState(R.id.hide, 300)
            player?.pause()
        }

        videoAdapter.submitList(videoList.videos)
        playerVideoAdapter.submitList(videoList.videos)
    }


    private fun initControl() {
        binding.controlButton.setOnClickListener {
            player?.let { exoPlayer ->
                if (exoPlayer.isPlaying) {
                    exoPlayer.pause()
                } else {
                    exoPlayer.play()
                }
            }
        }
    }

    private fun initVideoRecyclerView() {
        videoAdapter = VideoAdapter(this) { videoItem ->
            binding.motionLayout.setTransition(R.id.collapse, R.id.expand)
            binding.motionLayout.transitionToEnd()
            val list = listOf(videoItem) + videoList.videos.filter { it.id != videoItem.id }
            playerVideoAdapter.submitList(list)
            play(videoItem)
        }
        binding.videoListRecyclerView.adapter = videoAdapter
    }

    private fun initPlayerVideoRecyclerView() {
        playerVideoAdapter = PlayerVideoAdapter(this){ videoItem ->
            val list = listOf(videoItem) + videoList.videos.filter { it.id != videoItem.id }
            playerVideoAdapter.submitList(list)
            play(videoItem)
        }
        binding.playerRecyclerView.adapter = playerVideoAdapter
    }

    private fun initMotionLayout() {
        binding.motionLayout.targetView = binding.videoPlayerContainer
        binding.motionLayout.jumpToState(R.id.hide)

        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                binding.playerView.useController = false
            }

            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {

            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                binding.playerView.useController = currentId == R.id.expand
            }
        })
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
                binding.playerView.useController = false
                exoPlayer.addListener(object : Player.Listener {
                    override fun onIsPlayingChanged(isPlaying: Boolean) {
                        super.onIsPlayingChanged(isPlaying)

                        if(isPlaying){
                            binding.controlButton.setImageResource(R.drawable.baseline_pause_24)
                        } else {
                            binding.controlButton.setImageResource(R.drawable.baseline_play_arrow_24)
                        }
                    }
                })
            }
    }

    private fun play(videoItem: VideoItem){
        player?.setMediaItem(MediaItem.fromUri(Uri.parse(videoItem.videoUrl)))
        player?.prepare()
        player?.play()

        binding.videoTitleTextView.text = videoItem.title
    }
}