package com.ssong_develop.feature_result.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ssong_develop.core_navigation.IcatNavigationDestination

object ResultDestination : IcatNavigationDestination {
    override val route: String = "result_route"
    override val destination: String = "result_destination"
}

fun NavGraphBuilder.resultGraph() {

}
