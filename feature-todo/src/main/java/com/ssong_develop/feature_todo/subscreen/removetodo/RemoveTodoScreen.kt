package com.ssong_develop.feature_todo.subscreen.removetodo

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ssong_develop.feature_todo.subscreen.camera.CameraActivity
import com.ssong_develop.feature_todo.subscreen.removetodo.contract.CameraActivityContract
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun RemoveTodoScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    emptyFileUriString: String?,
    onClickReCaptureImage: () -> Unit,
    removeTodoViewModel: RemoveTodoViewModel = hiltViewModel()
) {
    val emptyFileUri = if (emptyFileUriString != null) Uri.parse(emptyFileUriString) else null
    var imageFileUri = remember { mutableStateOf(emptyFileUri) }
    val context = LocalContext.current
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = CameraActivityContract(),
        onResult = { imageUri ->
            if (imageUri != null) {
                Log.d("ssong-develop","${imageUri}")
                imageFileUri.value = Uri.parse(imageUri)
            }
        }
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (emptyFileUri != null) {
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
                            onClickReCaptureImage()
                        },
                        content = {
                            Text("캡처 이미지 삭제")
                        }
                    )
                }
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