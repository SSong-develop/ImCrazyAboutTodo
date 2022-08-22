package com.ssong_develop.imcrazyabouttodo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ssong_develop.feature_wificonnect.WifiConnectService
import com.ssong_develop.imcrazyabouttodo.permission.Permission
import com.ssong_develop.imcrazyabouttodo.ui.IcatApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalPermissionsApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, WifiConnectService::class.java))
        setContent {
            Permission(
                content = {
                    IcatApp()
                }
            )
        }
    }

    override fun onDestroy() {
        stopService(Intent(this,WifiConnectService::class.java))
        super.onDestroy()
    }
}
