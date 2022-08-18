package com.ssong_develop.model

data class Todo(
    val id: String,
    val title: String,
    val description: String,
    // LocalDateTime
    val createdAt: String,
    val deadline: Int
)
