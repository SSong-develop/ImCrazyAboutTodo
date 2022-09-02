package com.ssong_develop.feature_todo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ssong_develop.core_camera.ui.CameraCapture
import com.ssong_develop.feature_todo.navigation.AddTodoDestination
import com.ssong_develop.feature_todo.navigation.CameraDestination
import com.ssong_develop.feature_todo.navigation.RemoveTodoDestination
import com.ssong_develop.feature_todo.navigation.TodoDestination
import com.ssong_develop.feature_todo.subscreen.addtodo.AddTodoScreen
import com.ssong_develop.feature_todo.subscreen.removetodo.RemoveTodoScreen
import com.ssong_develop.feature_todo.subscreen.todo.TodoScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalCoroutinesApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopLevelTodoScreen() {
    val subTodoNavController = rememberNavController()

    NavHost(
        navController = subTodoNavController,
        startDestination = TodoDestination.route
    ) {
        composable(route = TodoDestination.route) {
            TodoScreen(navHostController = subTodoNavController)
        }
        composable(route = AddTodoDestination.route) {
            AddTodoScreen(navHostController = subTodoNavController)
        }
        composable(route = RemoveTodoDestination.route) {
            RemoveTodoScreen()
        }
    }
}
