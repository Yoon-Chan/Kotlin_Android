package com.example.face_regognition.recognition

import android.graphics.PointF
import android.graphics.RectF
import android.util.SizeF

interface FaceAnalyzerListener {

    fun detect()

    fun stopDetect()

    fun notDetect()

    fun detectProgress(progress : Float, message: String)

    fun facSize(rectF: RectF, sizeF: SizeF, pointF: PointF)
}