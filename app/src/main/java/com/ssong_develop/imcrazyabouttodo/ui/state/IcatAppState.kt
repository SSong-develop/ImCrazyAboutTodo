package com.ssong_develop.imcrazyabouttodo.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ssong_develop.core_design.R
import com.ssong_develop.feature_chat.navigation.ChattingDestination
import com.ssong_develop.feature_todophotoalbum.navigation.TodoPhotoAlbumDestination
import com.ssong_develop.feature_todo.navigation.TodoDestination
import com.ssong_develop.imcrazyabouttodo.navigation.TopLevelDestination

@Composable
fun rememberIcatAppState(
    navController: NavHostController = rememberNavController()
): IcatAppState {
    return remember(navController) {
        IcatAppState()
    }
}

@Stable
class IcatAppState {
    val topLevelDestinations = listOf(
        TopLevelDestination(
            route = TodoDestination.route,
            destination = TodoDestination.destination,
            icon = R.drawable.ic_todo,
            iconTextId = com.ssong_develop.feature_todo.R.string.todo_icon_text_id
        ),
        TopLevelDestination(
            route = ChattingDestination.route,
            destination = ChattingDestination.destination,
            icon = R.drawable.ic_profile,
            iconTextId = com.ssong_develop.feature_profile.R.string.profile_icon_text_id
        ),
        TopLevelDestination(
            route = TodoPhotoAlbumDestination.route,
            destination = TodoPhotoAlbumDestination.destination,
            icon = R.drawable.ic_result,
            iconTextId = com.ssong_develop.feature_result.R.string.result_icon_text_id
        )
    )
}

@Stable
enum class IcatScreenState {
    UNABLE_WIFI_ADDRESS, ENABLE_WIFI_ADDRESS, ERROR, SPLASH
}