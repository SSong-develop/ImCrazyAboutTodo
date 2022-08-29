package com.ssong_develop.feature_todo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.TodoRepository
import com.ssong_develop.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todos = todoRepository.getTodosStream()

    val fakeItemList = flowOf(
        listOf<Todo>()
    )
}