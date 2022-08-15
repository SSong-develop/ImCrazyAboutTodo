package com.ssong_develop.core_notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

fun NotificationManager.createWifiConnectNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelName = context.getString(R.string.wifi_connect_channel_name)
        val channelDescription = context.getString(R.string.wifi_connect_channel_description)
        val channelImportance = IMPORTANCE_DEFAULT
        val wifiChannel = NotificationChannel(
            context.getString(R.string.wifi_connect_channel_id),
            channelName,
            channelImportance
        ).also {
            it.description = channelDescription
        }
        createNotificationChannel(wifiChannel)
    }
}

fun NotificationManager.sendWifiConnectNotification(
    context: Context,
    kClass : Class<*>,
    messageBody: String
) {
    val contentIntent = Intent(context,kClass)

    val contentPendingIntent = PendingIntent.getActivity(
        context,
        1,
        contentIntent,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_ONE_SHOT
        }
    )

    val builder = NotificationCompat.Builder(
        context,
        context.getString(R.string.wifi_connect_channel_id)
    )
        .setContentTitle("등록된 wifi가 연결되었습니다.")
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    notify(1,builder.build())

}