package com.ssong_develop.feature_todo.subscreen.todo

import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todos = todoRepository.getTodosStream()
}