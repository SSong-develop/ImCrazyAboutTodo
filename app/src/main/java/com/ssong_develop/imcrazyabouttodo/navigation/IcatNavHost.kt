package com.ssong_develop.imcrazyabouttodo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ssong_develop.feature_chat.ChattingScreen
import com.ssong_develop.feature_chat.navigation.ChattingDestination
import com.ssong_develop.feature_todophotoalbum.TodoPhotoAlbumScreen
import com.ssong_develop.feature_todophotoalbum.navigation.TodoPhotoAlbumDestination
import com.ssong_develop.feature_todo.TopLevelTodoScreen
import com.ssong_develop.feature_todo.navigation.TopLevelTodoDestination

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun IcatNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = TopLevelTodoDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = TopLevelTodoDestination.route) {
            TopLevelTodoScreen()
        }
        composable(route = ChattingDestination.route) {
            ChattingScreen()
        }
        composable(route = TodoPhotoAlbumDestination.route) {
            TodoPhotoAlbumScreen()
        }
    }
}
