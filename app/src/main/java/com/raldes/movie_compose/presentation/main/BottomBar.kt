package com.raldes.movie_compose.presentation.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raldes.movie_compose.presentation.routing.RouteScreen

@Composable
fun BottomBar (navController: NavController, items: List<RouteScreen>) {
    
    BottomNavigation {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry?.destination

        items.forEach { myScreen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any {
                        it.route == myScreen.route
                } == true,
                onClick = {
                    navController.navigate(myScreen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = myScreen.icon, contentDescription = null)
                },
                label = {
                    Text(text = myScreen.label)
                })
        }
    }
}