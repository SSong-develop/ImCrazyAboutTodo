package com.ssong_develop.feature_todo.subscreen.removetodo

import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RemoveTodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

}