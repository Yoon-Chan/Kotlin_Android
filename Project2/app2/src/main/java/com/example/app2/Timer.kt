package com.example.app2


import android.os.Handler
import android.os.Looper

class Timer(listener: OnTimerTickListener) {

    companion object{
        private const val TIME_MILLI = 40L
    }
    private var duration : Long = 0L

    private val handler = Handler(Looper.getMainLooper())
    private val runnable : Runnable = object : Runnable{
        override fun run() {
            duration += TIME_MILLI
            handler.postDelayed(this, TIME_MILLI)
            listener.onTick(duration)
        }
    }

    fun start(){
        handler.postDelayed(runnable, TIME_MILLI)
    }

    fun stop(){
        duration = 0L
        handler.removeCallbacks(runnable)
    }

}


interface OnTimerTickListener {
    fun onTick(duration : Long)
}