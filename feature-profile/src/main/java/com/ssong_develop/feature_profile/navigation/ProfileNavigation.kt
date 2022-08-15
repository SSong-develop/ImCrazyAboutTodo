package com.ssong_develop.feature_profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ssong_develop.core_navigation.IcatNavigationDestination

object ProfileDestination : IcatNavigationDestination {
    override val route: String = "profile_route"
    override val destination: String = "profile_destination"
}

fun NavGraphBuilder.profileGraph() {

}
