package com.example.face_regognition.recognition

import android.graphics.PointF
import android.graphics.RectF
import android.media.Image
import android.util.SizeF
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.view.PreviewView
import androidx.lifecycle.Lifecycle
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import kotlin.math.abs

internal class FaceAnalyzer(
    lifecycle: Lifecycle,
    private val preview: PreviewView,
    private val listener: FaceAnalyzerListener?
) : ImageAnalysis.Analyzer {

    private var widthScaleFactor = 1f
    private var heightScaleFactor = 1f

    private var preCenterX = 0f
    private var preCenterY = 0f
    private var preWidth = 0f
    private var preHeight = 0f

    private val options = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
        .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
        .setMinFaceSize(0.4f)
        .build()

    private val detector = FaceDetection.getClient(options)
    private var detectStatus = FaceAnalyzerStatus.UNDETECT
    private val successListener = OnSuccessListener<List<Face>> { faces ->
        val face = faces.firstOrNull()
        if (face != null) {
            if (detectStatus == FaceAnalyzerStatus.UNDETECT) {
                detectStatus = FaceAnalyzerStatus.DETECT
                listener?.detect()
                listener?.detectProgress(25F, "얼굴을 인식했습니다.\n왼쪽 눈만 깜빡여주세요.")
            } else if (detectStatus == FaceAnalyzerStatus.DETECT && (face.leftEyeOpenProbability
                    ?: 0F) > EYE_SUCCESS_VALUE && (face.rightEyeOpenProbability
                    ?: 0F) < EYE_SUCCESS_VALUE
            ) {
                detectStatus = FaceAnalyzerStatus.LEFT_WINK
                listener?.detectProgress(50F, "오른쪽 눈만 깜빡여주세요")
            } else if (detectStatus == FaceAnalyzerStatus.LEFT_WINK
                && (face.leftEyeOpenProbability ?: 0F) < EYE_SUCCESS_VALUE
                && (face.rightEyeOpenProbability ?: 0F) > EYE_SUCCESS_VALUE
            ) {
                detectStatus = FaceAnalyzerStatus.RIGHT_WINK
                listener?.detectProgress(75F, "활짝 웃어보세요")
            } else if (detectStatus == FaceAnalyzerStatus.RIGHT_WINK
                && (face.smilingProbability ?: 0F) > SMILE_SUCCESS_VALUE
            ) {
                detectStatus = FaceAnalyzerStatus.SMILE
                listener?.detectProgress(100F, "얼굴 인식이 완료되었습니다.")
                listener?.stopDetect()
                detector.close()
            }
            calDetectSize(face)
        } else if (detectStatus != FaceAnalyzerStatus.UNDETECT && detectStatus != FaceAnalyzerStatus.SMILE) {
            detectStatus = FaceAnalyzerStatus.UNDETECT
            listener?.notDetect()
            listener?.detectProgress(0F, "얼굴을 인식하지 못했습니다.\n처음으로 돌아갑니다.")
        }
    }

    private val failureListener = OnFailureListener { e ->
        detectStatus = FaceAnalyzerStatus.UNDETECT
    }

    init {
        lifecycle.addObserver(detector)
    }

    override fun analyze(image: ImageProxy) {
        widthScaleFactor = preview.width.toFloat() / image.height
        heightScaleFactor = preview.height.toFloat() / image.width
        detectFaces(image)
    }

    private fun detectFaces(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if(mediaImage != null){
            val image = InputImage.fromMediaImage(
                mediaImage,
                imageProxy.imageInfo.rotationDegrees
            )
            detector.process(image)
                .addOnSuccessListener(successListener)
                .addOnFailureListener(failureListener)
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }

    private fun calDetectSize(face: Face) {
        val rect = face.boundingBox
        val boxWidth = rect.width()
        val boxHeight = rect.height()

        val left = rect.right.translateX() - (boxWidth / 2)
        val top = rect.top.translateY() - (boxHeight / 2)
        val right = rect.left.translateX() + (boxWidth / 2)
        val bottom = rect.bottom.translateY()

        val width = right - left
        val height = bottom - top
        val centerX = left + width / 2
        val centerY = top + height / 2

        if (abs(preCenterX - centerX) > PIVOT_OFFSET || abs(preCenterY - centerY) > PIVOT_OFFSET
            || abs(preWidth - width) > SIZE_OFFSET || abs(preHeight - height) > SIZE_OFFSET
        ) {
            listener?.facSize(
                RectF(left, top, right, bottom),
                SizeF(width, height),
                PointF(centerX, centerY)
            )

            preCenterX = centerX
            preCenterY = centerY
            preWidth = width
            preHeight = height
        }
    }

    private fun Int.translateX() = preview.width - (toFloat() * widthScaleFactor)
    private fun Int.translateY() = toFloat() * heightScaleFactor

    companion object {
        //성공 여부 수치
        private const val EYE_SUCCESS_VALUE = 0.1F
        private const val SMILE_SUCCESS_VALUE = 0.8F

        private const val PIVOT_OFFSET = 15
        private const val SIZE_OFFSET = 30
    }

}