package com.ssong_develop.imcrazyabouttodo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ssong_develop.feature_todo.navigation.TodoDestination
import com.ssong_develop.imcrazyabouttodo.navigation.IcatBottomNavigationBar
import com.ssong_develop.imcrazyabouttodo.navigation.IcatNavHost
import com.ssong_develop.imcrazyabouttodo.ui.theme.ImCrazyAboutToDoTheme

@Composable
fun IcatApp() {
    ImCrazyAboutToDoTheme {
        // A surface container using the 'background' color from the theme
        val navController = rememberNavController()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                bottomBar = { IcatBottomNavigationBar(navController = navController) },
                content = { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        IcatNavHost(
                            navController = navController,
                            startDestination = TodoDestination.route
                        )
                    }
                }
            )
        }
    }
}

