package com.ssong_develop.core_camera.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.ssong_develop.core_camera.screen.ui.theme.ImCrazyAboutToDoTheme
import com.ssong_develop.core_camera.ui.CameraCapture
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class CameraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImCrazyAboutToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CameraCapture(
                        modifier = Modifier,
                        onImageFile = { file ->
                            val intent = Intent()
                            intent.putExtra("imageUri",file.toUri().toString())
                            setResult(
                                RESULT_OK,
                                intent
                            )
                            finish()
                        }
                    )
                }
            }
        }
    }
}