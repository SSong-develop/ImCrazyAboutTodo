package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.TodoEntity
import com.ssong_develop.model.Todo

fun Todo.asEntityModel() = TodoEntity(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt
)