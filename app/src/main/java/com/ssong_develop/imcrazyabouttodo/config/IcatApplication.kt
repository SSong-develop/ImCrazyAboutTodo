package com.ssong_develop.imcrazyabouttodo.config

import android.app.Application
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.ssong_develop.core_notification.createWifiConnectNotificationChannel
import com.ssong_develop.feature_wificonnect.WifiConnectService
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@HiltAndroidApp
class IcatApplication : Application() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate() {
        super.onCreate()
        val notificationManager = applicationContext.getSystemService(NotificationManager::class.java) as NotificationManager
        notificationManager.createWifiConnectNotificationChannel(this)
    }

}