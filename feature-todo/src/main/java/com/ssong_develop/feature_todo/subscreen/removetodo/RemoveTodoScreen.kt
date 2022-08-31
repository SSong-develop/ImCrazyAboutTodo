package com.ssong_develop.feature_todo.subscreen.removetodo

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toFile
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ssong_develop.feature_todo.navigation.CameraDestination

@Composable
fun RemoveTodoScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    emptyFileUriString: String?,
    imageFileUriString: String?,
    onClickReCaptureImage: () -> Unit,
    removeTodoViewModel: RemoveTodoViewModel = hiltViewModel()
) {
    val emptyFileUri = if (emptyFileUriString != null) Uri.parse(emptyFileUriString) else null
    val imageFileUri = if (imageFileUriString != null) Uri.parse(imageFileUriString) else null

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
                            imageFileUri?.toFile()?.delete()
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
                navHostController.navigate(CameraDestination.route)
            },
            content = { Text("끝낸 TODO 인증하기") }
        )
    }
}