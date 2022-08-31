package com.ssong_develop.feature_todo.subscreen.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_data.repository.TodoRepository
import com.ssong_develop.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val todos = todoRepository.getTodosStream()

    fun deleteTodo(removedTodo : Todo) = viewModelScope.launch(ioDispatcher) {
        todoRepository.deleteTodo(removedTodo)
    }
}