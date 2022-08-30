package com.ssong_develop.core_data.repository

import com.ssong_develop.core_database.entity.TodoEntity
import com.ssong_develop.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodoStream(id: String): Flow<Todo>

    fun getTodosStream(): Flow<List<Todo>>

    suspend fun updateTodo(todo : Todo)

    suspend fun insertTodo(todo : Todo)

    suspend fun deleteTodo(todo : Todo)
}