package com.example.app2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class WaveformView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttre: Int = 0
) :
    View(context, attrs, defStyleAttre) {

    private val ampList = mutableListOf<Float>()
    private val rectList = mutableListOf<RectF>()
    private val rectWidth = 15f
    private var tick = 0

    private val redPaint = Paint().apply {
        color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (rectF in rectList) {
            canvas?.drawRect(rectF, redPaint)
        }
    }

    fun addAmplitude(maxAmplitude: Float) {

        val height = this.height
        val amplitude =
            ((maxAmplitude / Short.MAX_VALUE) * this.height) * 0.8f //0~1 사이의 값 * height 의 높이  = 전체 높이 값의 비율에 맞춰 값이 나온다.

        ampList.add(amplitude)
        rectList.clear()

        val maxRect = (this.width / rectWidth).toInt()

        val amps = ampList.takeLast(maxRect)

        for ((i, amp) in amps.withIndex()) {
            val rectF = RectF()
            rectF.top = (this.height / 2) - (amp / 2)
            rectF.bottom = rectF.top + amp
            rectF.left = i * rectWidth
            rectF.right = rectF.left + (rectWidth - 5f)

            rectList.add(rectF)
        }

        invalidate()
    }

    fun replayAmplitude() {
        rectList.clear()

        val maxRect = (this.width / rectWidth).toInt()

        val amps = ampList.take(tick).takeLast(maxRect)

        tick++

        for ((i, amp) in amps.withIndex()) {
            val rectF = RectF()
            rectF.top = (this.height / 2) - (amp / 2)
            rectF.bottom = rectF.top + amp
            rectF.left = i * rectWidth
            rectF.right = rectF.left + (rectWidth - 5f)

            rectList.add(rectF)
        }

        invalidate()

    }

    fun clearData() {
        ampList.clear()
    }

    fun clearWave() {
        rectList.clear()
        tick = 0
        invalidate()
    }
}