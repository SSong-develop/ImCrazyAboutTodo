package com.ssong_develop.feature_todophotoalbum

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

// Local Uri를 사진으로 들고 와주는 로직 작성
@Composable
fun TodoPhotoAlbumScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoPhotoAlbumViewModel = hiltViewModel()
) {
    val todoPhotos by viewModel.todoPhotos.collectAsState(initial = emptyList())

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
                items(todoPhotos.size) { index ->
                    Card(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 6.dp
                    ) {
                        Column(
                            modifier = modifier
                                .fillMaxWidth()
                        ) {
                            Text(todoPhotos[index].photo.toString())
                        }
                    }
                }
            }
        )
    }

}