package com.ssong_develop.imcrazyabouttodo.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.ssong_develop.core_design.theme.ImCrazyAboutToDoTheme
import com.ssong_develop.feature_mac_address.WifiAddressScreen
import com.ssong_develop.feature_todo.navigation.TodoDestination
import com.ssong_develop.imcrazyabouttodo.MainViewModel
import com.ssong_develop.imcrazyabouttodo.navigation.IcatBottomNavigationBar
import com.ssong_develop.imcrazyabouttodo.navigation.IcatNavHost
import com.ssong_develop.imcrazyabouttodo.ui.state.IcatScreenState.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun IcatApp(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    ImCrazyAboutToDoTheme {
        // A surface container using the 'background' color from the theme
        val icatScreenState by mainViewModel.isRegisterWifiAddress.collectAsState(initial = UNABLE_WIFI_ADDRESS)
        val navController = rememberNavController()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            when (icatScreenState) {
                UNABLE_WIFI_ADDRESS, ERROR -> {
                    WifiAddressScreen(
                        onClick = { /** No - options? **/ }
                    )
                }
                ENABLE_WIFI_ADDRESS -> {
                    Scaffold(
                        bottomBar = { IcatBottomNavigationBar(navController = navController) },
                        content = { padding ->
                            Box(modifier = Modifier.padding(padding)) {
                                IcatNavHost(
                                    navController = navController,
                                    startDestination = TodoDestination.route
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

