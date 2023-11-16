package me.xditya.sightsense.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import me.xditya.sightsense.ui.components.BottomAppBar
import me.xditya.sightsense.ui.components.TopAppBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar() }, bottomBar = { BottomAppBar(navController) }) {
        Surface(modifier = Modifier.padding(it)) {
            val cameraPermissionState = rememberPermissionState(
                android.Manifest.permission.CAMERA
            )
            if (!cameraPermissionState.status.isGranted) {
                NoPermissionContent { cameraPermissionState.launchPermissionRequest() }
            } else {
                CameraScreen()
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun NoPermissionContent(
    onRequestPermission: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onRequestPermission) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "ask_camera_usage_permission"
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = "Use Camera")
        }
    }
}