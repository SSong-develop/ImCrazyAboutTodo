package com.ssong_develop.core_data.repository

import com.ssong_develop.core_database.entity.TodoEntity
import com.ssong_develop.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodoStream(id: String): Flow<Todo>

    fun getTodosStream(): Flow<List<Todo>>

    fun updateTodo(todo : Todo)

    fun insertTodo(todo : Todo)

    fun deleteTodo(todo : Todo)
}