package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.Result

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "result")
data class ResultEntity(
    @PrimaryKey
    val id: String,
    val photo: Int,
    val photoDescription: String,
    val photoCreatedAt: String
)

fun ResultEntity.asExternalModel() = Result(
    id = id,
    photo = photo,
    photoDescription = photoDescription,
    photoCreatedAt = photoCreatedAt
)