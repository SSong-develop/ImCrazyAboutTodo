package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.ChatEntity
import com.ssong_develop.model.Chat

fun Chat.asEntityModel() = ChatEntity(
    id = id,
    message = message,
    createdAt = createdAt
)