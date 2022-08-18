package com.ssong_develop.imcrazyabouttodo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ssong_develop.feature_chat.ChattingScreen
import com.ssong_develop.feature_chat.navigation.ChattingDestination
import com.ssong_develop.`feature_todo-photo-album`.TodoPhotoAlbumScreen
import com.ssong_develop.`feature_todo-photo-album`.navigation.TodoPhotoAlbumDestination
import com.ssong_develop.feature_todo.TodoScreen
import com.ssong_develop.feature_todo.navigation.TodoDestination

@Composable
fun IcatNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = TodoDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = TodoDestination.route) {
            TodoScreen()
        }
        composable(route = ChattingDestination.route) {
            ChattingScreen()
        }
        composable(route = TodoPhotoAlbumDestination.route) {
            TodoPhotoAlbumScreen()
        }
    }
}
