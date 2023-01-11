package com.raldes.movie_compose.presentation.main

import android.media.MediaRouter2.RouteCallback
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raldes.movie_compose.presentation.favorites.FavoritesMovieScreen
import com.raldes.movie_compose.presentation.home.HomeMovieScreen
import com.raldes.movie_compose.presentation.routing.ListScreen
import com.raldes.movie_compose.presentation.routing.RouteScreen
import com.raldes.movie_compose.presentation.search.SearchMovieScreen
import com.raldes.movie_compose.presentation.tickets.TicketScreen
import kotlinx.coroutines.FlowPreview

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@FlowPreview
@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = RouteScreen.Discover.route) {
        //discover
        navigation(route = RouteScreen.Discover.route,
        startDestination = ListScreen.Discover.createRoute(RouteScreen.Discover)) {
            addDiscover(navHostController, RouteScreen.Discover)
        }

        navigation(route = RouteScreen.Search.route,
        startDestination = ListScreen.Search.createRoute(RouteScreen.Search)) {
            addSearch(navHostController, RouteScreen.Search)
        }

        navigation(route = RouteScreen.Favorite.route,
        startDestination = ListScreen.Favorite.creteRoute(RouteScreen.Favorite)) {
            addFavorites(navHostController, RouteScreen.Favorite)
        }

        navigation(route = RouteScreen.Ticket.route,
        startDestination = ListScreen.Ticket.createRoute(RouteScreen.Ticket)) {
            addTickets(RouteScreen.Ticket)
        }
    }
}

@FlowPreview
private fun NavGraphBuilder.addDiscover(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Discover.createRoute(routeScreen)) {
        HomeMovieScreen()
    }
}

@FlowPreview
private fun NavGraphBuilder.addSearch(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Search.createRoute(routeScreen)) {
        SearchMovieScreen()
    }
}

@FlowPreview
private fun NavGraphBuilder.addFavorites(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Favorite.creteRoute(routeScreen)) {
        FavoritesMovieScreen()
    }
}

@FlowPreview
private fun NavGraphBuilder.addTickets(routeScreen: RouteScreen) {
    composable(route = ListScreen.Ticket.createRoute(routeScreen)) {
        TicketScreen()
    }
}