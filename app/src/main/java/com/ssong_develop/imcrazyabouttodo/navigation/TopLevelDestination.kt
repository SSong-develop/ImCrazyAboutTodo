package com.ssong_develop.imcrazyabouttodo.navigation

import androidx.annotation.DrawableRes
import com.ssong_develop.core_design.icon.Icon
import com.ssong_develop.core_navigation.IcatNavigationDestination

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    @DrawableRes val icon: Int,
    val iconTextId: Int
) : IcatNavigationDestination