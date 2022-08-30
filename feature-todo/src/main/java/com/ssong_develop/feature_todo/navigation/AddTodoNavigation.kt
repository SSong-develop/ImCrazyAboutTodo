package com.ssong_develop.feature_todo.navigation

import com.ssong_develop.core_navigation.IcatNavigationDestination

object AddTodoDestination : IcatNavigationDestination {
    override val route: String = "add_todo_route"
    override val destination: String = "add_todo_destination"
}