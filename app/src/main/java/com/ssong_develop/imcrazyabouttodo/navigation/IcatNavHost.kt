package com.ssong_develop.imcrazyabouttodo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ssong_develop.feature_profile.ProfileScreen
import com.ssong_develop.feature_profile.navigation.ProfileDestination
import com.ssong_develop.feature_result.ResultScreen
import com.ssong_develop.feature_result.navigation.ResultDestination
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
        composable(route = ProfileDestination.route) {
            ProfileScreen()
        }
        composable(route = ResultDestination.route) {
            ResultScreen()
        }
    }
}
