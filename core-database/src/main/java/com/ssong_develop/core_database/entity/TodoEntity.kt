package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.Todo
import java.util.*

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val todoTitle: String,
    val todoSubTitle: String,
    // LocalDateTime
    val createdAt: String
)

fun TodoEntity.asExternalModel(): Todo = Todo(
    id = id,
    todoTitle = todoTitle,
    todoSubTitle = todoSubTitle,
    createdAt = createdAt
)