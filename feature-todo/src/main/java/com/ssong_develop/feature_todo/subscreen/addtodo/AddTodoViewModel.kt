package com.ssong_develop.feature_todo.subscreen.addtodo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_common.di.MainDispatcher
import com.ssong_develop.core_data.repository.TodoRepository
import com.ssong_develop.feature_todo.format.formatter
import com.ssong_develop.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
) : ViewModel() {

    val todoTitle = MutableStateFlow("")
    val todoDescription = MutableStateFlow("")

    val enabled = combine(
        todoTitle,
        todoDescription
    ) { title, description ->
        title.length in 2..14 && description.length in 10..20
    }

    fun postTodoTitle(title: String) {
        todoTitle.value = title
    }

    fun postTodoDescription(description: String) {
        todoDescription.value = description
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveTodo() = viewModelScope.launch(ioDispatcher) {
        todoRepository.insertTodo(
            Todo(
                id = UUID.randomUUID().toString(),
                title = todoTitle.value,
                description = todoDescription.value,
                createdAt = formatter.format(LocalDateTime.now()),
                deadline = 1
            )
        )
    }
}