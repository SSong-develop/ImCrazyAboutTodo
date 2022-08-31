package com.ssong_develop.feature_todo.navigation

import com.ssong_develop.core_navigation.IcatNavigationDestination

object RemoveTodoDestination : IcatNavigationDestination {
    override val route: String = "remove_todo_route"
    override val destination: String = "remove_todo_destination"
}
