package com.ssong_develop.imcrazyabouttodo.config

import android.app.Application
import android.content.Intent
import com.ssong_develop.feature_wificonnect.WifiConnectService
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@HiltAndroidApp
class IcatApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}