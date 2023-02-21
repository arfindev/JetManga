package com.example.jetmanga.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetmanga.presentation.Home_Screen.HomeScreen
import com.example.jetmanga.presentation.detail_screen.MangaDetailScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.MangaListScreen.route) {
        composable(route = Screen.MangaListScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
        composable(
            route = Screen.MangaDetailScreen.route, arguments = listOf(navArgument(
                "id"
            ) {
                type = NavType.StringType
            })
        ) {
            MangaDetailScreen()
        }
    }

}