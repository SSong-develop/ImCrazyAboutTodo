package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.TodoPhoto

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "todo_photo")
data class TodoPhotoEntity(
    @PrimaryKey
    val id: String,
    val photo: Int,
    val photoDescription: String,
    val photoCreatedAt: String
)

fun TodoPhotoEntity.asExternalModel() = TodoPhoto(
    id = id,
    photo = photo,
    photoDescription = photoDescription,
    photoCreatedAt = photoCreatedAt
)