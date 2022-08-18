package com.ssong_develop.`feature_todo-photo-album`.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ssong_develop.core_navigation.IcatNavigationDestination

object TodoPhotoAlbumDestination : IcatNavigationDestination {
    override val route: String = "todo_photo_album_route"
    override val destination: String = "todo_photo_album_destination"
}
