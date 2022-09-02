package com.ssong_develop.feature_todophotoalbum

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

// Local Uri를 사진으로 들고 와주는 로직 작성
@Composable
fun TodoPhotoAlbumScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoPhotoAlbumViewModel = hiltViewModel()
) {
    val todoPhotos by viewModel.todoPhotos.collectAsState(initial = emptyList())

    val todoImageBitmaps by viewModel.todoBitmapFlow.collectAsState(initial = emptyList())

    if (todoPhotos.isEmpty()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("해결한 Todo를 등록해주세요.")
        }
    } else {
        LazyColumn(
            content = {
                items(todoImageBitmaps.size) { index ->
                    Card(
                        modifier = modifier
                            .wrapContentSize()
                            .padding(20.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 6.dp
                    ) {
                        // 변환은 됐고, 변환을 이제 어떻게 효과적으로 할거이며 그게 문제일거 같다.
                        Column(
                            modifier = modifier
                                .wrapContentSize()
                        ) {
                            Image(
                                bitmap = todoImageBitmaps[index],
                                contentDescription = "hello world!"
                            )
                        }
                    }
                }
            }
        )
    }

}