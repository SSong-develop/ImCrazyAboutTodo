package com.ssong_develop.core_data.repository

import com.ssong_develop.model.TodoPhoto
import kotlinx.coroutines.flow.Flow

interface TodoPhotoRepository {

    fun getTodoPhotoStream(id: String): Flow<TodoPhoto>

    fun getTodoPhotoStream(): Flow<List<TodoPhoto>>

    fun insertTodoPhoto(todoPhoto: TodoPhoto)

    fun deleteTodoPhoto(todoPhoto: TodoPhoto)

    fun updateTodoPhoto(todoPhoto: TodoPhoto)
}