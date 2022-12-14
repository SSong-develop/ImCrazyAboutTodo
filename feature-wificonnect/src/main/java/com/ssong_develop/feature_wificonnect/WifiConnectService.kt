package com.ssong_develop.feature_wificonnect

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import com.ssong_develop.core_data.repository.WifiAddressRepository
import com.ssong_develop.core_network.networkchecker.NetworkChecker
import com.ssong_develop.core_notification.sendWifiConnectNotification
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import java.net.Inet4Address
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class WifiConnectService : Service() {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    @Inject
    lateinit var networkChecker: NetworkChecker

    @Inject
    lateinit var wifiAddressRepository: WifiAddressRepository

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            startNetworkChecking()
        }
    }

    override fun onDestroy() {
        cancelNetworkChecking()
        super.onDestroy()
    }

    @SuppressLint("MissingPermission", "HardwareIds")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun startNetworkChecking() {
        val notificationManager =
            getSystemService(NotificationManager::class.java) as NotificationManager
        scope.launch {
            networkChecker.networkStatusFlow.collect { networkStatus ->
                when (networkStatus) {
                    NetworkChecker.NetworkStatus.Loading -> {
                        Log.d("ssong-develop", "loading")
                    }
                    is NetworkChecker.NetworkStatus.OnAvailable -> {
                        Log.d("ssong-develop", "onAvailable ${networkStatus.network}")
                    }
                    is NetworkChecker.NetworkStatus.OnBlockedStatusChanged -> {
                        Log.d("ssong-develop", "onBlocked Status changed")
                    }
                    is NetworkChecker.NetworkStatus.OnCapabilitiesChanged -> {
                        Log.d("ssong-develop", "capabilitiesChange")
                    }
                    is NetworkChecker.NetworkStatus.OnLinkPropertiesChanged -> {
                        val connectedWifiAddress =
                            networkStatus.linkProperties.linkAddresses.first { it.address is Inet4Address }
                                .toString()
                        // TODO ssong-develop
                        // AppDatabase??? ???????????? ?????? ip????????? ??? ????????? ??????????????? Wifi????????? ????????? ????????? ?????? ??????????????? ???????????????????????? ???????????? ??????.
                        val userWifiAddress =
                            wifiAddressRepository.getWifiAddressStream().first()?.wifiAddress ?: "".also {
                                // ?????? ????????? ????????????????????? ??????
                            }
                        if (connectedWifiAddress == "${userWifiAddress}/24") {
                            notificationManager.sendWifiConnectNotification(
                                this@WifiConnectService,
                                ""
                            )
                        }
                    }
                    is NetworkChecker.NetworkStatus.OnLosing -> {
                        Log.d("ssong-develop", "onLosing")
                    }
                    is NetworkChecker.NetworkStatus.OnLost -> {
                        Log.d("ssong-develop", "onLost ${networkStatus.network}")
                    }
                    NetworkChecker.NetworkStatus.OnUnAvailable -> {
                        Log.d("ssong-develop", "onUnAvailable")
                    }
                }
            }
        }
    }

    private fun cancelNetworkChecking() {
        scope.launch {
            job.cancelAndJoin()
        }
    }
}