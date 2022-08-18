package com.ssong_develop.feature_todo

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ssong_develop.core_camera.ui.CameraPreview
import com.ssong_develop.model.Todo

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    viewModel: ToDoViewModel = hiltViewModel()
) {
    // Ui Data
    val listState = rememberLazyListState()
    var selectedPosition by remember { mutableStateOf(-1) }

    // Business Data
    val todos by viewModel.fakeItemList.collectAsState(initial = emptyList())

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar() {
                Text("할 일")
            }
        },
        floatingActionButton = {
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
        },
        content = { paddingValues ->
            if (todos.isEmpty()) {
                EmptyTodoContent(
                    modifier = modifier,
                    padding = paddingValues
                )
            } else {
                TodoContent(
                    listState = listState,
                    todos = todos,
                    selectedPosition = selectedPosition,
                    onChangeSelectedPosition = { index ->
                        selectedPosition = index
                    }
                )
            }
        }
    )
}

@Composable
fun EmptyTodoContent(
    modifier: Modifier = Modifier,
    padding: PaddingValues
) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(padding),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("Todo를 등록해주세요.")
//    }
    CameraPreview()
}

@Composable
fun TodoContent(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    todos: List<Todo>,
    selectedPosition: Int,
    onChangeSelectedPosition: (index: Int) -> Unit
) {
    LazyColumn(
        state = listState,
        content = {
            items(todos.size) { index ->
                Card(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = 6.dp
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Checkbox(
                            checked = selectedPosition == index,
                            onCheckedChange = { _ ->
                                onChangeSelectedPosition(index)
                            }
                        )
                        Text(todos[index].title)
                    }
                }
            }
        }
    )
}
