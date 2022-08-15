package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ResultEntity
import com.ssong_develop.core_database.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo where id = :todoId")
    fun getTodo(todoId: String) : Flow<TodoEntity>

    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<TodoEntity>>

    @Delete
    fun deleteTodo(todoEntity: TodoEntity)

    @Update
    fun updateTodo(todoEntity: TodoEntity)
}