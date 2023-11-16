package me.xditya.sightsense.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.xditya.sightsense.ui.screens.CameraScreen
import me.xditya.sightsense.ui.screens.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("camera") {
            CameraScreen()
        }
    }
}