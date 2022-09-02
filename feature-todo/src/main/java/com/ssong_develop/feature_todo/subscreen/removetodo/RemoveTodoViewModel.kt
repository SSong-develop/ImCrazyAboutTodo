package com.ssong_develop.feature_todo.subscreen.removetodo

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_data.repository.TodoPhotoRepository
import com.ssong_develop.core_data.repository.TodoRepository
import com.ssong_develop.feature_todo.format.formatter
import com.ssong_develop.model.Todo
import com.ssong_develop.model.TodoPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RemoveTodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
    private val todoPhotoRepository: TodoPhotoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun removeTodo(
        removeTodoPhotoByteArray: ByteArray,
        successClosure: () -> Unit,
        failedClosure: () -> Unit
    ) {
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                todoPhotoRepository.insertTodoPhoto(
                    TodoPhoto(
                        id = UUID.randomUUID().toString(),
                        photo = removeTodoPhotoByteArray,
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
    }
}