package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.TodoPhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoPhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodoPhoto(todoPhotoEntity: TodoPhotoEntity)

    @Query("SELECT * FROM todo_photo where id = :todoPhotoId")
    fun getTodoPhoto(todoPhotoId: String): Flow<TodoPhotoEntity>

    @Query("SELECT * FROM todo_photo")
    fun getTodoPhotos(): Flow<List<TodoPhotoEntity>>

    @Delete
    fun deleteTodoPhoto(todoPhotoEntity: TodoPhotoEntity)

    @Update
    fun updateTodoPhoto(todoPhotoEntity: TodoPhotoEntity)
}