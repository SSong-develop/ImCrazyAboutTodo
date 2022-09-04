package com.ssong_develop.feature_todo.subscreen.removetodo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.core_common.di.DefaultDispatcher
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_data.repository.TodoPhotoRepository
import com.ssong_develop.core_data.repository.TodoRepository
import com.ssong_develop.feature_todo.format.formatter
import com.ssong_develop.model.TodoPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.time.LocalDateTime
import java.util.*
import java.util.zip.Deflater
import javax.inject.Inject

@HiltViewModel
class RemoveTodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
    private val todoPhotoRepository: TodoPhotoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun removeTodo(
        removeTodoPhotoUriString: String,
        removeTodoPhotoByteArray: ByteArray,
        successClosure: () -> Unit,
        failedClosure: () -> Unit
    ) {
        viewModelScope.launch(defaultDispatcher) {
            runCatching {
                // byteArray를 가공
                compressByteArray(removeTodoPhotoByteArray)
            }.onSuccess {
                viewModelScope.launch(ioDispatcher) {
                    runCatching {
                        todoPhotoRepository.insertTodoPhoto(
                            TodoPhoto(
                                id = UUID.randomUUID().toString(),
                                uriString = removeTodoPhotoUriString,
                                photo = it,
                                photoDescription = "temp",
                                photoCreatedAt = formatter.format(LocalDateTime.now())
                            )
                        )
                    }.onSuccess {
                        withContext(Dispatchers.Main) {
                            successClosure()
                        }
                    }.onFailure {
                        withContext(Dispatchers.Main) {
                            failedClosure()
                        }
                    }
                }
            }.onFailure {

            }
        }
    }

    private fun compressByteArray(byteArray: ByteArray) : ByteArray{
        val baos = ByteArrayOutputStream()
        BitmapFactory.decodeByteArray(byteArray,0,byteArray.size).apply {
            compress(Bitmap.CompressFormat.JPEG,50,baos)
        }
        return baos.toByteArray()
    }

}