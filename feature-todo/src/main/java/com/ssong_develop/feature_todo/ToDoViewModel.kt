package com.ssong_develop.feature_todo

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    @ApplicationContext context : Context
) : ViewModel() {

}