package com.ssong_develop.feature_todo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.TodoRepository
import com.ssong_develop.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// fixme ssong-develop
// 어떻게 하면 CheckBox Single Selection이 가능할까 생각해봐야 할듯
@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todos = todoRepository.getTodosStream()

    val fakeItemList = flowOf(
        listOf<Todo>()
    )
}