package com.ssong_develop.feature_chat.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ssong_develop.core_navigation.IcatNavigationDestination

object ChattingDestination : IcatNavigationDestination {
    override val route: String = "chatting_route"
    override val destination: String = "chatting_destination"
}

fun NavGraphBuilder.profileGraph() {

}
