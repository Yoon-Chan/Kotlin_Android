package com.example.securityapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

//문자 조건
/*
*   1. 문자 내용이 140바이트를 초과하면 안된다.
*   2. 문자 맨 앞에 <#> 포함되어야한다.
*   3. 맨 마지막에 앱을 식별하는 11글자 해시코드가 존재해야한다.
* */
class AuthOtpReceiver : BroadcastReceiver() {

    private var listener: OtpReceiveListener? = null

    interface OtpReceiveListener {
        fun onOtpReceived(otp: String)
    }

    fun setOtpListener(listener: OtpReceiveListener) {
        Log.d("123456", "setListener")
        this.listener = listener
    }

    fun doFilter() = IntentFilter().apply {
        Log.d("123456", "register start")
        addAction(SmsRetriever.SMS_RETRIEVED_ACTION)
    }

    companion object {
        private const val PATTERN = "^<#>.*\\[Sample\\].+\\[(\\d{6})\\].+\$"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == SmsRetriever.SMS_RETRIEVED_ACTION){
            Log.d("123456", "status Success")
            intent.extras?.let {  bundle ->
                val status = bundle.get(SmsRetriever.EXTRA_STATUS) as Status
                when (status.statusCode){
                    CommonStatusCodes.SUCCESS -> {
                        val otpSms = bundle.getString(SmsRetriever.EXTRA_SMS_MESSAGE, "")
                        if(listener != null && otpSms.isNotEmpty()){
                            val otp = PATTERN.toRegex().find(otpSms)?.destructured?.component1()
                            if(!otp.isNullOrBlank()){
                                listener?.onOtpReceived(otp)
                            }
                        }
                    }
                }
            }
        }
    }
}