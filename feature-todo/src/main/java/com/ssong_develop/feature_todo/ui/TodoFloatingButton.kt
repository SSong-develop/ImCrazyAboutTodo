package com.ssong_develop.feature_todo.ui

import android.util.Log
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ssong_develop.feature_todo.R
import com.ssong_develop.model.Todo

@Composable
fun TodoFloatingButton(
    modifier: Modifier = Modifier,
    selectedPosition: Int,
    todos: List<Todo>
) {
    FloatingActionButton(
        onClick = {
            if (selectedPosition != -1) {
                Log.d("ssong-develop", "${todos[selectedPosition]}")
            }
        },
        elevation = FloatingActionButtonDefaults.elevation(8.dp),
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_trash_can),
                contentDescription = ""
            )
        }
    )
}