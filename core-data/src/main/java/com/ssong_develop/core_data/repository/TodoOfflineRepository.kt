package com.ssong_develop.core_data.repository

import com.ssong_develop.core_data.model.asEntityModel
import com.ssong_develop.core_database.dao.TodoDao
import com.ssong_develop.core_database.entity.asExternalModel
import com.ssong_develop.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoOfflineRepository @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {
    override fun getTodoStream(id: String): Flow<Todo> =
        todoDao.getTodo(id).map { entity -> entity.asExternalModel() }

    override fun getTodosStream(): Flow<List<Todo>> = todoDao.getTodos().map { entities ->
        entities.map { entity -> entity.asExternalModel() }
    }

    override suspend fun insertTodo(todo: Todo) = todoDao.insertTodo(todo.asEntityModel())

    override suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo.asEntityModel())

    override suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo.asEntityModel())
}