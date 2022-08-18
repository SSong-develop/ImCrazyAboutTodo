package com.ssong_develop.core_camera.ui

import android.util.Log
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import com.ssong_develop.core_camera.provider.getCameraProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@Composable
fun CameraPreview(
    modifier: Modifier = Modifier
) {
    // rememberCoroutineScope() returns a CoroutineScope that is "bound" to the current Composable context.
    val coroutineScope = rememberCoroutineScope()
    // LocalLifecycleOwner : compositionLocal containing the current LifecycleOwner
    // CompositionLocals can be used as an implicit way to have data flow through a composition
    // it is primarily used to surface necessary Android view system objects like (in this case) LifecycleOwner
    val lifecycleOwner = LocalLifecycleOwner.current

    val scaleType: PreviewView.ScaleType = remember { PreviewView.ScaleType.FILL_CENTER }
    val cameraSelector: CameraSelector = remember {CameraSelector.DEFAULT_BACK_CAMERA }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            val previewView = PreviewView(context).apply {
                this.scaleType = scaleType
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }

            // CameraX Preview Usecase
            val previewUseCase = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }

            coroutineScope.launch {
                val cameraProvider = context.getCameraProvider()
                try {
                    // must unBind the use-cases before rebinding them.
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,cameraSelector,previewUseCase
                    )
                } catch (exception : Exception) {
                    Log.e("CameraPreview","use case binding failed ${exception}")
                }
            }

            previewView
        }
    )
}