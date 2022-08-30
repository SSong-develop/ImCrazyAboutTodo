package com.ssong_develop.feature_todo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssong_develop.feature_todo.subscreen.addtodo.AddTodoScreen
import com.ssong_develop.feature_todo.navigation.AddTodoDestination
import com.ssong_develop.feature_todo.navigation.TodoDestination
import com.ssong_develop.feature_todo.subscreen.todo.TodoScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopLevelTodoScreen(
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TodoDestination.route
    ) {
        composable(route = TodoDestination.route) {
            TodoScreen(navHostController = navController)
        }
        composable(route = AddTodoDestination.route) {
            AddTodoScreen(navHostController = navController)
        }
    }
}
