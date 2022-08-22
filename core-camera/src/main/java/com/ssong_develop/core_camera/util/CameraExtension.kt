package com.ssong_develop.core_camera.util

import android.util.Log
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.Executor
import kotlin.coroutines.resumeWithException

// takePicture get result as a File object
@ExperimentalCoroutinesApi
suspend fun ImageCapture.takePicture(executor: Executor): File {
    val photoFile = withContext(Dispatchers.IO) {
        runCatching {
            File.createTempFile("image","jpg")
        }.getOrElse { exception ->
            Log.e("TakePicture","Failed to create temporary file",exception)
            File("/dev/null")
        }
    }

    return suspendCancellableCoroutine { continuation ->
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        val onImageSavedCallbackImpl = object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                continuation.resume(photoFile){}
            }

            override fun onError(exception: ImageCaptureException) {
                Log.e("TakePicture","Image capture failed",exception)
                continuation.resumeWithException(exception)
            }
        }
        takePicture(outputOptions, executor,onImageSavedCallbackImpl)
    }
}