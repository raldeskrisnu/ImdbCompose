package com.raldes.movie_compose.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.raldes.movie_compose.presentation.main.BottomBar
import com.raldes.movie_compose.presentation.main.Navigation
import com.raldes.movie_compose.presentation.routing.ListScreen
import com.raldes.movie_compose.presentation.routing.RouteScreen
import kotlinx.coroutines.FlowPreview

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@FlowPreview
@Composable
@Preview
fun MainScreen () {

    val navController = rememberNavController()
    val rootsScreens = listOf(RouteScreen.Discover, RouteScreen.Search, RouteScreen.Favorite, RouteScreen.Ticket)

    val mainRoutes = listOf(
        ListScreen.Discover.createRoute(RouteScreen.Discover),
        ListScreen.Search.createRoute(RouteScreen.Search),
        ListScreen.Favorite.creteRoute(RouteScreen.Favorite),
        ListScreen.Ticket.createRoute(RouteScreen.Ticket))

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in mainRoutes

    Scaffold(bottomBar = {
        BottomBar(navController = navController, items = rootsScreens)
    }, content = {
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues = it)) {
            Navigation(navController)
        }
    })
}