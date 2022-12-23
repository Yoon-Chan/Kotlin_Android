package com.example.ch8_event

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.ch8_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //뒤로가기 버튼을 누른 시각을 저장하는 속성
    var initTime = 0L

    //멈춘 시각을 저장하는 속성
    var pauseTime = 0L
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()

            //버튼 표시 여부 조정
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false

            setBackGround(binding.startButton.isEnabled,binding.stopButton.isEnabled, binding.resetButton.isEnabled)
        }

        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.startButton.isEnabled = true

            binding.stopButton.isEnabled = false

            binding.resetButton.isEnabled = true

            setBackGround(binding.startButton.isEnabled,binding.stopButton.isEnabled, binding.resetButton.isEnabled)
        }

        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.stopButton.isEnabled = false

            binding.startButton.isEnabled= true

            binding.resetButton.isEnabled = false

            setBackGround(binding.startButton.isEnabled,binding.stopButton.isEnabled, binding.resetButton.isEnabled)
        }
    }

    private fun setBackGround(startButton : Boolean, stopButton : Boolean, resetButton : Boolean){
        when(startButton){
            true -> binding.startButton.setBackgroundResource(R.drawable.round_button)
            false -> binding.startButton.setBackgroundResource(R.drawable.round_button_fasle)
        }

        when(stopButton){
            true -> binding.stopButton.setBackgroundResource(R.drawable.round_button)
            false -> binding.stopButton.setBackgroundResource(R.drawable.round_button_fasle)
        }

        when(resetButton){
            true -> binding.resetButton.setBackgroundResource(R.drawable.round_button)
            false -> binding.resetButton.setBackgroundResource(R.drawable.round_button_fasle)
        }

    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            //뒤로가기 버튼을 처음 눌렀거나 누른지 3초가 지났을 때 처리
            if(System.currentTimeMillis() - initTime > 3000){
                Toast.makeText(this, "종료하려면 한 번 더 누르세요", Toast.LENGTH_SHORT ).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}