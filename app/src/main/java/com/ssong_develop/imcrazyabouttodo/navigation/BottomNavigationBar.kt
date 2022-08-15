package com.ssong_develop.imcrazyabouttodo.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ssong_develop.imcrazyabouttodo.R
import com.ssong_develop.imcrazyabouttodo.ui.state.rememberIcatAppState

@Composable
fun IcatBottomNavigationBar(navController: NavController) {

    val icatAppState = rememberIcatAppState()

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        icatAppState.topLevelDestinations.forEach { topLevelDestination ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = topLevelDestination.icon),
                        contentDescription = null
                    )
                },
                label = { topLevelDestination.iconTextId },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == topLevelDestination.route,
                onClick = {
                    navController.navigate(topLevelDestination.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}