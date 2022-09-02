package com.ssong_develop.feature_todo.subscreen.removetodo

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
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
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ssong_develop.core_camera.screen.CameraActivity
import com.ssong_develop.feature_todo.subscreen.removetodo.contract.CameraActivityContract
import kotlinx.coroutines.ExperimentalCoroutinesApi

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
                cameraLauncher.launch(Intent(context,CameraActivity::class.java))
            },
            content = { Text("끝낸 TODO 인증하기") }
        )
    }
}