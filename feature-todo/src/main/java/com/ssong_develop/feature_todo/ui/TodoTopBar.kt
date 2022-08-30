package com.ssong_develop.feature_todo.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun TodoTopBar(
    modifier: Modifier,
    onClickAddTodo: () -> Unit
) {
    var showMenuState by remember { mutableStateOf(false) }

    /** Drawer 위치 **/
    TopAppBar(
        title = {
            Text("할 일")
        },
        modifier = modifier,
        navigationIcon = { /** Drawer 위치 **/ },
        actions = {
            IconButton(onClick = { showMenuState = !showMenuState }) {
                Icon(Icons.Default.MoreVert, "MoreVert")
            }
            DropdownMenu(
                expanded = showMenuState,
                onDismissRequest = { showMenuState = false },
                modifier = modifier,
                offset = DpOffset(0.dp, 0.dp),
                content = {
                    DropdownMenuItem(
                        onClick = { onClickAddTodo() },
                        content = {
                            Icon(Icons.Filled.Add, "추가")
                        }
                    )
                }
            )
        },
        backgroundColor = Color.DarkGray,
        contentColor = Color.Green,
        elevation = 6.dp
    )
}