package me.xditya.sightsense.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import me.xditya.sightsense.ui.components.BottomAppBar
import me.xditya.sightsense.ui.components.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar() }, bottomBar = { BottomAppBar(navController) }) {
        Surface(modifier = Modifier.padding(it)) {}
    }
}