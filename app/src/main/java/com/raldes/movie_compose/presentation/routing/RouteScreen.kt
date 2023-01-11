package com.raldes.movie_compose.presentation.routing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MovieFilter
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class RouteScreen(val route: String, val label: String, val icon: ImageVector) {

    object Discover: RouteScreen(route = "discover", label = "Discover", Icons.Default.MovieFilter)

    object Search: RouteScreen(route = "search", label = "Search", Icons.Default.Search)

    object Favorite: RouteScreen(route = "favorites", label = "Favorites", Icons.Default.Favorite)

    object Ticket: RouteScreen(route = "tickets", label = "Tickets", Icons.Default.Movie)
}

sealed class ListScreen(val route: String) {

    object Discover: ListScreen("discover") {
        fun createRoute(root: RouteScreen) = "${root.route}/$route"
    }

    object Search:ListScreen("search") {
        fun createRoute(root: RouteScreen) = "${root.route}/$route"
    }

    object Favorite: ListScreen("favorite") {
        fun creteRoute(root: RouteScreen) = "${root.route}/$route"
    }

    object Ticket: ListScreen("tickets") {
        fun createRoute(root: RouteScreen) = "${root.route}/$route"
    }
}