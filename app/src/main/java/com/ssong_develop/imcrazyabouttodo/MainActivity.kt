package com.ssong_develop.imcrazyabouttodo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ssong_develop.feature_mac_address.InputMacAddressScreen
import com.ssong_develop.feature_wificonnect.WifiConnectService
import com.ssong_develop.imcrazyabouttodo.ui.IcatApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, WifiConnectService::class.java))
        setContent {
            IcatApp()
        }
    }

    override fun onDestroy() {
        stopService(Intent(this,WifiConnectService::class.java))
        super.onDestroy()
    }
}