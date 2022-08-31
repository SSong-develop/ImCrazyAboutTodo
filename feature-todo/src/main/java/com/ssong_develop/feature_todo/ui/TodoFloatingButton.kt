package com.ssong_develop.feature_todo.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ssong_develop.feature_todo.R
import com.ssong_develop.model.Todo

@Composable
fun TodoFloatingButton(
    modifier: Modifier = Modifier,
    selectedPosition: Int,
    todos: List<Todo>,
    onClickFloatingButton: (removedTodo : Todo) -> Unit
) {
    val context = LocalContext.current

    FloatingActionButton(
        onClick = {
            if (selectedPosition == -1) {
                context.showToast("삭제하고 싶은 Todo를 선택하세요")
            } else {
                onClickFloatingButton(todos[selectedPosition])
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

fun Context.showToast(message : String) =
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()