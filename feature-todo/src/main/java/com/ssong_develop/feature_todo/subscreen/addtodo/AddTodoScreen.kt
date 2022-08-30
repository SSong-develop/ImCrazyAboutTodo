package com.ssong_develop.feature_todo.subscreen.addtodo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ssong_develop.feature_todo.navigation.TodoDestination

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddTodoScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    addTodoViewModel: AddTodoViewModel = hiltViewModel()
) {
    val title by addTodoViewModel.todoTitle.collectAsState()
    val description by addTodoViewModel.todoDescription.collectAsState()
    val buttonEnabled by addTodoViewModel.enabled.collectAsState(initial = false)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
            value = title,
            onValueChange = { inputValue ->
                addTodoViewModel.postTodoTitle(inputValue)
            }
        )

        TextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
            value = description,
            onValueChange = { inputValue ->
                addTodoViewModel.postTodoDescription(inputValue)
            }
        )

        Spacer(modifier = modifier.weight(1f))

        Button(
            onClick = {
                addTodoViewModel.saveTodo()
                navHostController.navigate(TodoDestination.route)
            },
            content = {
                Text("추가")
            },
            modifier = modifier
                .fillMaxWidth(),
            enabled = buttonEnabled
        )
    }
}