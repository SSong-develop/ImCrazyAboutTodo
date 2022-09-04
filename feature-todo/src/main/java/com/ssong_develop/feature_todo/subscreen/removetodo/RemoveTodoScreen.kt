package com.ssong_develop.feature_todo.subscreen.removetodo

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toFile
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.ssong_develop.core_camera.screen.CameraActivity
import com.ssong_develop.feature_todo.subscreen.removetodo.contract.CameraActivityContract
import com.ssong_develop.feature_todo.ui.showToast
import com.ssong_develop.feature_todo.util.calculateInSampleSize
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.ByteArrayOutputStream

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalCoroutinesApi
@Composable
fun RemoveTodoScreen(
    modifier: Modifier = Modifier,
    emptyFileUriString: String = "/dev/null",
    removeTodoViewModel: RemoveTodoViewModel = hiltViewModel()
) {
    val emptyFileUri by remember { mutableStateOf(Uri.parse(emptyFileUriString))}
    var imageFileUri by remember { mutableStateOf(emptyFileUri) }

    val context = LocalContext.current

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = CameraActivityContract(),
        onResult = { imageUri ->
            imageUri?.let {
                imageFileUri = Uri.parse(it)
            }
        }
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (imageFileUri != emptyFileUri) {
            Column(modifier = modifier) {
                Image(
                    modifier = modifier
                        .width(300.dp)
                        .height(300.dp),
                    painter = rememberImagePainter(imageFileUri),
                    contentDescription = "Captured Image"
                )
                Button(
                    modifier = modifier,
                    onClick = {
                        imageFileUri.toFile().delete()
                        imageFileUri = emptyFileUri
                    },
                    content = {
                        Text("캡처 이미지 삭제")
                    }
                )
            }
        }

        Spacer(modifier = modifier.weight(1f))
        Button(
            modifier = modifier.padding(bottom = 20.dp),
            onClick = {
                if (imageFileUri != emptyFileUri) {
                    removeTodoViewModel.removeTodo(
                        imageFileUri.toString(),
                        imageFileUri.toFile().readBytes(),
                        successClosure = {
                            context.showToast("성공")
                        },
                        failedClosure = {
                            context.showToast("실패")
                        }
                    )
                } else {
                    cameraLauncher.launch(Intent(context,CameraActivity::class.java))
                }
            },
            content = {
                if (imageFileUri != emptyFileUri) {
                    Text("할일 삭제")
                } else {
                    Text("인증하기")
                }
            }
        )
    }
}