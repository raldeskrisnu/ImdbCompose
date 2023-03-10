package com.raldes.movie_compose.presentation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raldes.movie_compose.presentation.favorites.FavoritesMovieScreen
import com.raldes.movie_compose.presentation.home.HomeMovieScreen
import com.raldes.movie_compose.presentation.moviedetails.MovieDetailScreen
import com.raldes.movie_compose.presentation.routing.ListScreen
import com.raldes.movie_compose.presentation.routing.RouteScreen
import com.raldes.movie_compose.presentation.search.SearchMovieScreen
import com.raldes.movie_compose.presentation.series.SeriesScreen
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
            addMovieDetail(navHostController, RouteScreen.Discover)
            addSearch(navHostController, RouteScreen.Discover)
        }

        navigation(route = RouteScreen.Search.route,
        startDestination = ListScreen.Search.createRoute(RouteScreen.Search)) {
            addSearch(navHostController, RouteScreen.Search)
        }

        navigation(route = RouteScreen.Favorite.route,
        startDestination = ListScreen.Favorite.creteRoute(RouteScreen.Favorite)) {
            addFavorites(navHostController, RouteScreen.Favorite)
            addMovieDetail(navHostController, RouteScreen.Favorite)
        }

        navigation(route = RouteScreen.Series.route,
        startDestination = ListScreen.Series.createRoute(RouteScreen.Series)) {
            addSeries(navHostController,RouteScreen.Series)
            addMovieDetail(navHostController,RouteScreen.Series)
        }
    }
}

@FlowPreview
private fun NavGraphBuilder.addDiscover(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Discover.createRoute(routeScreen)) {
        HomeMovieScreen(gotoDetailScreen = {
            navController.navigate(ListScreen.MovieDetails.createRoute(routeScreen,it))
        }, gotoSearchScreen = {
            navController.navigate(ListScreen.Search.createRoute(routeScreen))
        })
    }
}

@FlowPreview
private fun NavGraphBuilder.addSearch(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Search.createRoute(routeScreen)) {
        SearchMovieScreen(onBackPressed = {
            navController.popBackStack()
        }, openMovieDetails = {
            navController.navigate(ListScreen.MovieDetails.createRoute(routeScreen, it))
        })
    }
}

@FlowPreview
private fun NavGraphBuilder.addFavorites(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Favorite.creteRoute(routeScreen)) {
        FavoritesMovieScreen(gotoMovieDetails = {
            navController.navigate(ListScreen.MovieDetails.createRoute(routeScreen, it))
        })
    }
}

@FlowPreview
private fun NavGraphBuilder.addSeries(navController: NavController, routeScreen: RouteScreen) {
    composable(route = ListScreen.Series.createRoute(routeScreen)) {
        SeriesScreen(openMovieDetails = {
            navController.navigate(ListScreen.MovieDetails.createRoute(routeScreen, it, true))
        })
    }
}

private fun NavGraphBuilder.addMovieDetail(navController: NavController, rootScreen: RouteScreen) {
    composable(route = ListScreen.MovieDetails.createRoute(rootScreen),
                arguments = listOf(navArgument("movieId") {
                    NavType.LongType
                }, navArgument("isSeries") {
                    NavType.BoolType
                })
    ) {
        MovieDetailScreen(onBackPressed = {
            navController.popBackStack()
       })
    }
}