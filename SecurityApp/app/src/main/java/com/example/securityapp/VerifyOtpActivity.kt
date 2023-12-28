package com.example.securityapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.securityapp.databinding.ActivityVerifyOtpBinding
import com.example.securityapp.util.ViewUtil.setOnEditorActionListener
import com.example.securityapp.util.ViewUtil.showKeyboardDelay
import com.google.android.gms.auth.api.phone.SmsRetriever

class VerifyOtpActivity : AppCompatActivity(), AuthOtpReceiver.OtpReceiveListener {
    private lateinit var binding: ActivityVerifyOtpBinding
    private var timer: CountDownTimer? = object : CountDownTimer(3 * 60 * 1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val min = (millisUntilFinished / 1000) / 60
            val sec = (millisUntilFinished / 1000) % 60
            binding.timerTextView.text = "$min:${String.format("%02d",sec)}"
        }

        override fun onFinish() {
            binding.timerTextView.text = ""
            Toast.makeText(
                this@VerifyOtpActivity,
                "입력 제한시간을 초과하였습니다.\n다시 시도해주세요.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private var smsReceiver : AuthOtpReceiver? = null

    override fun onResume() {
        super.onResume()
        binding.otpCodeEdit.showKeyboardDelay()
        startSmsReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearTimer()
        stopSmsReceiver()
    }

    private fun initView(){
        startTimer()
        with(binding){
            otpCodeEdit.doAfterTextChanged {
                if(otpCodeEdit.length() >= 6) {
                    stopTimer()
                    Toast.makeText(this@VerifyOtpActivity, "인증번호 입력에 완료되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            otpCodeEdit.setOnEditorActionListener(EditorInfo.IME_ACTION_DONE){

            }
        }
    }

    private fun startTimer() {
        timer?.start()
    }

    private fun stopTimer() {
        timer?.cancel()
    }

    private fun clearTimer() {
        startTimer()
        timer = null
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private fun startSmsReceiver() {
        SmsRetriever.getClient(this).startSmsRetriever().also {task ->
            task.addOnSuccessListener {
                if(smsReceiver == null){
                    smsReceiver = AuthOtpReceiver().apply {
                        setOtpListener(this@VerifyOtpActivity)
                    }
                }
                registerReceiver(smsReceiver, smsReceiver!!.doFilter())
            }

            task.addOnFailureListener {
                stopSmsReceiver()
            }
        }
    }

    private fun stopSmsReceiver() {
        if(smsReceiver != null){
            unregisterReceiver(smsReceiver)
            smsReceiver = null
        }
    }

    override fun onOtpReceived(otp: String) {
        binding.otpCodeEdit.setText(otp)
    }
}