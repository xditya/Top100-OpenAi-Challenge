package me.xditya.sightsense.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomAppBar(navController: NavController) {
    val currentDestination = navController.currentDestination?.route
    BottomAppBar(actions = {
        FloatingActionButton(onClick = {
            if (currentDestination != "home") navController.navigate("home")
        }, modifier = Modifier.padding(10.dp)) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
            )
        }
    },
        floatingActionButton = {
            ExtendedFloatingActionButton(text = { Text("Open Camera") }, icon = {
                Icon(
                    Icons.Outlined.Info, contentDescription = "open camera"
                )
            }, onClick = {
                navController.navigate("camera")
            })
        })
}