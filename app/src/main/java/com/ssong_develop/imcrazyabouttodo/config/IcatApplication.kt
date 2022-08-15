package com.ssong_develop.imcrazyabouttodo.config

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IcatApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}