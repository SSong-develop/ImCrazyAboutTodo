package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.Profile

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val createAt: String
)

fun ProfileEntity.asExternalModel() = Profile(
    id = id,
    name = name,
    description = description,
    createAt = createAt
)