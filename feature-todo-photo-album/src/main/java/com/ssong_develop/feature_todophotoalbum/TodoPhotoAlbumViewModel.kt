package com.ssong_develop.feature_todophotoalbum

import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.TodoPhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoPhotoAlbumViewModel @Inject constructor(
    private val todoPhotoRepository: TodoPhotoRepository
) : ViewModel() {

    val todoPhotos = todoPhotoRepository.getTodoPhotoStream()

}