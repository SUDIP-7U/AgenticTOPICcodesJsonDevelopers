package com.example.myapplication.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavRoute(val route: String, val title: String, val icon: ImageVector) {
    data object Home : NavRoute("home", "Home", Icons.Default.Home)
    data object Movies : NavRoute("movies", "Movies", Icons.Default.Movie)
    data object Notifications : NavRoute("notifications", "Notifications", Icons.Default.Notifications)
}
