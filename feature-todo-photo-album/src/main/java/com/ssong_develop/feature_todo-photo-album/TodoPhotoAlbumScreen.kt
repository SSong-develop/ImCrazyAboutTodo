package com.ssong_develop.`feature_todo-photo-album`

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
import com.ssong_develop.`feature_todo-photo-album`.TodoPhotoAlbumViewModel

@Composable
fun TodoPhotoAlbumScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoPhotoAlbumViewModel = hiltViewModel()
) {
    val results by viewModel.results.collectAsState(initial = emptyList())

    if (results.isEmpty()) {
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
                items(results.size) { index ->
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
                            Text(results[index].photo.toString())
                        }
                    }
                }
            }
        )
    }

}