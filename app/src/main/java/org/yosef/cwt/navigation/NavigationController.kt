package org.yosef.cwt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.yosef.cwt.screns.HomeScreen

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreensViews.HomeScreen.name
    ) {
        composable(ScreensViews.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}