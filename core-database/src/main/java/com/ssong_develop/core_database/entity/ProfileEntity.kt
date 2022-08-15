package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val createAt: String
)
