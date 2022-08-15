package com.ssong_develop.core_workmanager

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.CoroutineWorker
import androidx.work.WorkManager
import androidx.work.WorkerParameters

class WifiNotificationWorker(
    private val context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    @RequiresApi(Build.VERSION_CODES.M)
    override suspend fun doWork(): Result {
        val notificationManager = context.getSystemService(NotificationManager::class.java) as NotificationManager

        return Result.success()
    }
}