package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.Chat

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "chatting")
data class ChatEntity(
    @PrimaryKey
    val id: String,
    val message: String,
    val createdAt: String
)

fun ChatEntity.asExternalModel() = Chat(
    id = id,
    message = message,
    createdAt = createdAt
)