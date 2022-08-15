package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.TodoEntity
import com.ssong_develop.model.Todo

fun Todo.asEntityModel() = TodoEntity(
    id = id,
    todoTitle = todoTitle,
    todoSubTitle = todoSubTitle,
    createdAt = createdAt
)