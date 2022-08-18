package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.Todo
import java.util.*

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    // LocalDateTime
    val createdAt: String,
    val deadline: Int
)

fun TodoEntity.asExternalModel(): Todo = Todo(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    deadline = deadline
)