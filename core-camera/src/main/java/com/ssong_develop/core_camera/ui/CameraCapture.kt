package com.ssong_develop.core_camera.ui

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY
import androidx.camera.core.Preview
import androidx.camera.core.UseCase
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.ssong_develop.core_camera.provider.executor
import com.ssong_develop.core_camera.provider.getCameraProvider
import com.ssong_develop.core_camera.util.takePicture
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import java.io.File

// TODO 코드 좀 더 봐야함
@ExperimentalCoroutinesApi
@Composable
fun CameraCapture(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
    onImageFile: (File) -> Unit = {}
) {
    Box(modifier = modifier) {
        val context = LocalContext.current
        val lifecycleOwner = LocalLifecycleOwner.current
        val coroutineScope = rememberCoroutineScope()
        var previewUseCase by remember { mutableStateOf<UseCase>(Preview.Builder().build())}
        val imageCaptureUseCase by remember {
            mutableStateOf(
                ImageCapture.Builder()
                    .setCaptureMode(CAPTURE_MODE_MAXIMIZE_QUALITY)
                    .build()
            )
        }
        CameraPreview(
            modifier = Modifier.fillMaxSize(),
            onUseCase = {
                previewUseCase = it
            }
        )
        Button(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                coroutineScope.launch {
                    imageCaptureUseCase.takePicture(context.executor).let {
                        onImageFile(it)
                    }
                }
            }
        ) {
            Text("Capture!")
        }
        LaunchedEffect(previewUseCase) {
            val cameraProvider = context.getCameraProvider()
            try {
                // Must unbind the use-cases before rebinding them.
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner, cameraSelector, previewUseCase, imageCaptureUseCase
                )
            } catch (exception : Exception) {
                Log.e("CameraCapture", "Failed to bind camera use cases", exception)
            }
        }
    }
}