package com.example.faceapp

import android.graphics.PointF
import android.graphics.RectF
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SizeF
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.transition.TransitionManager
import com.example.face_regognition.Camera
import com.example.face_regognition.recognition.FaceAnalyzerListener
import com.example.faceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FaceAnalyzerListener {

    private lateinit var binding : ActivityMainBinding
    private val camera = Camera(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setProgressText("시작하기를 눌러주세요")
        camera.initCamera(binding.cameraLayout, this)

        binding.startDetectButton.setOnClickListener {
            it.isVisible = false
            binding.faceOverlayView.reset()
            camera.startFaceDetect()
            setProgressText("얼굴을 보여주세요")
        }

    }

    override fun facSize(rectF: RectF, sizeF: SizeF, pointF: PointF) {
        binding.faceOverlayView.setSize(rectF, sizeF, pointF)
    }

    override fun detectProgress(progress: Float, message: String) {
        setProgressText(message)
        binding.faceOverlayView.setProgress(progress)
    }

    override fun detect() {

    }

    override fun notDetect() {
        binding.faceOverlayView.reset()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun stopDetect() {
        camera.stopFaceDetect()
        reset()
    }

    private fun reset(){
        binding.startDetectButton.isVisible = true
    }

    private fun setProgressText(text : String){
        TransitionManager.beginDelayedTransition(binding.root)
        binding.progressTextView.text = text
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        camera.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}