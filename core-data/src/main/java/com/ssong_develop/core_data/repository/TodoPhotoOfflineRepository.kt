package com.ssong_develop.core_data.repository

import com.ssong_develop.core_data.model.asEntityModel
import com.ssong_develop.core_database.dao.TodoPhotoDao
import com.ssong_develop.core_database.entity.asExternalModel
import com.ssong_develop.model.TodoPhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoPhotoOfflineRepository @Inject constructor(
    private val todoPhotoDao: TodoPhotoDao
) : TodoPhotoRepository {
    override fun getTodoPhotoStream(id: String): Flow<TodoPhoto> =
        todoPhotoDao.getTodoPhoto(id).map { entity -> entity.asExternalModel() }

    override fun getTodoPhotoStream(): Flow<List<TodoPhoto>> = todoPhotoDao.getTodoPhotos().map { entities ->
        entities.map { entity -> entity.asExternalModel() }
    }

    override fun insertTodoPhoto(todoPhoto: TodoPhoto) = todoPhotoDao.insertTodoPhoto(todoPhoto.asEntityModel())

    override fun deleteTodoPhoto(todoPhoto: TodoPhoto) = todoPhotoDao.deleteTodoPhoto(todoPhoto.asEntityModel())

    override fun updateTodoPhoto(todoPhoto: TodoPhoto) = todoPhotoDao.updateTodoPhoto(todoPhoto.asEntityModel())
}