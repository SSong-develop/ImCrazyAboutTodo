package com.ssong_develop.feature_todophotoalbum

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

// Local Uri를 사진으로 들고 와주는 로직 작성

// 고민을 좀 해봐야할 거 같은데요
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
            modifier = modifier,
            content = {
                items(todoPhotos.size) { index ->
                    Card(
                        modifier = modifier
                            .wrapContentSize()
                            .padding(20.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 6.dp
                    ) {
                        Column(
                            modifier = modifier
                        ) {
                            Column(
                                modifier = modifier
                                    .fillMaxWidth()
                            ) {
                                loadPicture(
                                    uri = todoPhotos[index].uriString.toUri(),
                                    placeholder = null
                                )?.let {
                                    Image(
                                        painter = it,
                                        contentDescription = "null"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun loadPicture(uri: Uri,placeholder: Painter? = null): Painter? {
    // Glide로 해도 렉걸리네 뭐임...
    // 뭘로 해야돼
    var state by remember {
        mutableStateOf(placeholder)
    }

    val context = LocalContext.current
    val result = object : CustomTarget<Bitmap>() {
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            state = BitmapPainter(resource.asImageBitmap())
        }

        override fun onLoadCleared(p: Drawable?) {
            state = placeholder
        }
    }

    try {
        Glide.with(context)
            .asBitmap()
            .load(uri)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(result)
    } catch(exception : Exception) {

    }
    return state
}