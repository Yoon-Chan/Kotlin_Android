package com.example.face_regognition

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.Executors

class Camera(private val context: Context) : ActivityCompat.OnRequestPermissionsResultCallback {

    private val preview by lazy {
        Preview.Builder()
            .build()
            .also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
    }

    private lateinit var previewView: PreviewView
    private val cameraSelector by lazy {
        CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_FRONT)
            .build()
    }

    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>

    private var cameraExecutor = Executors.newSingleThreadExecutor()


    fun permissionCheck(context: Context){
        val permissionList = listOf(Manifest.permission.CAMERA)

        if(!PermissionUtil().checkPermission(context as Activity, permissionList)){
            PermissionUtil().requestPermission(context, permissionList)
        }else{
            openPreview()
        }
    }
    fun initCamera(layout: ViewGroup) {
        previewView = PreviewView(context)
        layout.addView(previewView)
        permissionCheck(context)
    }

    private fun openPreview() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(context)
            .also { providerFuture ->
                providerFuture.addListener({

                }, ContextCompat.getMainExecutor(context))
            }
    }

    private fun startPreview(context: Context) {
        val cameraProvider = cameraProviderFuture.get()
        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                context as LifecycleOwner,
                cameraSelector,
                preview
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        var flag = true
        if(grantResults.isNotEmpty()){
            for ((i, _) in permissions.withIndex()){
                if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    flag = false
                }
            }
            if(flag){
                openPreview()
            } else {
                Toast.makeText(context, "권한을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                (context as Activity).finish()
            }
        }
    }
}