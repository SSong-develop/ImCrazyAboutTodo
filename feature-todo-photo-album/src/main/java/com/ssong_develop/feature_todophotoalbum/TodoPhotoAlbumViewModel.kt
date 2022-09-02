package com.ssong_develop.feature_todophotoalbum

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.ssong_develop.core_common.di.DefaultDispatcher
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_data.repository.TodoPhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class TodoPhotoAlbumViewModel @Inject constructor(
    private val todoPhotoRepository: TodoPhotoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    val todoPhotos = todoPhotoRepository.getTodoPhotoStream()

    val todoBitmapFlow = todoPhotos.map {
        it.map {
            BitmapFactory.decodeByteArray(it.photo,0,it.photo.size).asImageBitmap()
        }
    }.flowOn(defaultDispatcher)

}