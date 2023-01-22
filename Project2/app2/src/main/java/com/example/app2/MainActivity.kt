package com.example.app2

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.app2.databinding.ActivityMainBinding
import android.Manifest
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(), OnTimerTickListener {

    companion object {
        private const val REQUEST_RECORD_AUDIO_CODE = 200
    }

    private lateinit var timer :Timer
    private lateinit var binding: ActivityMainBinding
    private var recorder: MediaRecorder? = null
    private var player : MediaPlayer? = null
    private var fileName: String = ""
    private var state: State = State.RELEASE

    //릴리즈 - 녹음중 - 릴리즈
    // 릴리즈 - 재생 - 릴리즈
    enum class State {
        RELEASE, RECORDING, PLAYING
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //절대 경로/audiorecordtest.3gp 파일로 이동
        fileName = "${externalCacheDir?.absolutePath}/audiorecordtest.3gp"
        timer = Timer(this)

        binding.recordButton.setOnClickListener {
            when (state) {
                State.RELEASE -> {
                    record()
                }
                State.RECORDING -> {
                    onRecord(false)
                }
                State.PLAYING -> {

                }
            }
        }

        binding.playdButton.setOnClickListener {
            when (state) {
                State.RELEASE -> {
                    onPlay(true)
                }
                else -> {

                    //do nothing
                }
            }
        }

        binding.stopdButton.setOnClickListener {
            when (state) {

                State.PLAYING -> {
                    onPlay(false)
                }
                else -> {
                    //do nothing
                }
            }
        }

    }

    private fun onPlay(start : Boolean) = if(start) startPlaying() else stopPlaying()

    private fun startPlaying(){
        state = State.PLAYING

        player = MediaPlayer().apply {
            try {
                setDataSource(fileName)
                prepare()
            }catch (e: Exception){
                Log.e("APP", "media player prepare failed ${e.printStackTrace()}")
            }
            start()
        }

        // 녹음이 끝났을 때
        player?.setOnCompletionListener {
            stopPlaying()
        }


        binding.recordButton.isEnabled = false
        binding.recordButton.alpha = 0.3f

    }

    private fun stopPlaying(){
        state = State.RELEASE

        player?.release()
        player = null

        binding.recordButton.isEnabled = true
        binding.recordButton.alpha = 1.0f

    }

    private fun record() {
        state = State.RECORDING

        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
                //녹음을 시작하는 곳 (권한 확인)

                onRecord(true)
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.RECORD_AUDIO
            ) -> {
                // In an educational UI, explain to the user why your app requires this
                // permission for a specific feature to behave as expected, and what
                // features are disabled if it's declined. In this UI, include a
                // "cancel" or "no thanks" button that lets the user continue
                // using your app without granting the permission.
                showPermissionRationalDialog()
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    REQUEST_RECORD_AUDIO_CODE
                )
            }
        }
    }

    //record가 시작되는 함수
    private fun onRecord(start: Boolean) = if (start) {
        startRecording()
    } else
        stopRecording()


    private fun startRecording() {
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            //실패할 수 있기 때문에 예외 처리
            try {
                //준비 완료
                prepare()
            } catch (e: Exception) {
                Log.e("APP", "prepare() failed ${e.printStackTrace()}")
            }

            start()
        }

        //최대 진폭
        timer.start()

        
        binding.recordButton.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.baseline_stop_24
            )
        )

        binding.recordButton.imageTintList = ColorStateList.valueOf(Color.BLACK)

        binding.playdButton.isEnabled = false
        binding.playdButton.alpha = 0.3f
    }

    private fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }

        recorder = null
        timer.stop()
        state = State.RELEASE
        binding.recordButton.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.baseline_fiber_manual_record_24
            )
        )

        binding.recordButton.imageTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.red))

        binding.playdButton.isEnabled =true
        binding.playdButton.alpha = 1.0f
    }


    private fun showPermissionRationalDialog() {
        AlertDialog.Builder(this)
            .setMessage("녹음 권한을 켜주셔야지 앱을 정상적으로 사용할 수 있습니다.")
            .setPositiveButton("권한 허용하기") { _, _ ->
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    REQUEST_RECORD_AUDIO_CODE
                )

            }
            .setNegativeButton("취소") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .show()
    }

    private fun showPermissionSettingDialog() {
        AlertDialog.Builder(this)
            .setMessage("녹음 권한을 켜주셔야 앱을 정상적으로 사용할 수 있다. 앱 설정으로 진입하셔서 권한을 켜주세요")
            .setPositiveButton("권한 변경하러 가기") { _, _ ->
                navigateToAppSetting()
            }
            .setNegativeButton("취소") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .show()
    }

    //이 앱의 앱 세팅 화면으로 넘어가는 함수.
    private fun navigateToAppSetting() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", packageName, null)
        }
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val audioRecordPermissionGranted = requestCode == REQUEST_RECORD_AUDIO_CODE
                && grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED

        if (audioRecordPermissionGranted) {
            onRecord(true)
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.RECORD_AUDIO
                )
            )
                showPermissionRationalDialog()
            else {
                showPermissionSettingDialog()
            }
        }

    }

    override fun onTick(duration: Long) {
        binding.waveformView.addAmplitude(recorder?.maxAmplitude?.toFloat() ?: 0f )
    }
}