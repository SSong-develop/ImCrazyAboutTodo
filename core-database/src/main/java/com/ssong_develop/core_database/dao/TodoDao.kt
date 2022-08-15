package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ResultEntity
import com.ssong_develop.core_database.entity.TodoEntity

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo where id = :todoId")
    fun getTodo(todoId: String)

    // FIXME ssong-develop 에러가 날 수 있어요요
    @Delete
    fun deleteTodo()

    @Update
    fun updateTodo()
}