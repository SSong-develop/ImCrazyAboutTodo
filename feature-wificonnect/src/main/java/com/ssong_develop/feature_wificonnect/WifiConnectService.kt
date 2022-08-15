package com.ssong_develop.feature_wificonnect

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.net.wifi.WifiInfo
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_network.networkchecker.NetworkChecker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import java.net.Inet4Address
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class WifiConnectService: Service() {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    @Inject
    lateinit var networkChecker: NetworkChecker

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
        scope.launch {
            networkChecker.networkStatusFlow.collect { networkStatus ->
                when (networkStatus) {
                    NetworkChecker.NetworkStatus.Loading -> {
                        Log.d("ssong-develop","loading")
                    }
                    is NetworkChecker.NetworkStatus.OnAvailable -> {
                        Log.d("ssong-develop","onAvailable ${networkStatus.network}")
                    }
                    is NetworkChecker.NetworkStatus.OnBlockedStatusChanged -> {
                        Log.d("ssong-develop","onBlocked Status changed")
                    }
                    is NetworkChecker.NetworkStatus.OnCapabilitiesChanged -> {
                        Log.d("ssong-develop","capabilitiesChange")
                    }
                    is NetworkChecker.NetworkStatus.OnLinkPropertiesChanged -> {
                        val wifiIpAddress = networkStatus.linkProperties.linkAddresses.first{ it.address is Inet4Address }
                        // TODO ssong-develop
                        // AppDatabase에 등록되어 있는 ip주소와 이 주소가 동일하다면 Wifi연결과 해야할 일들에 대한 리스트들이 노티피케이션으로 넘어오면 된다.
                        Log.d("ssong-develop",wifiIpAddress.toString())
                    }
                    is NetworkChecker.NetworkStatus.OnLosing -> {
                        Log.d("ssong-develop","onLosing")
                    }
                    is NetworkChecker.NetworkStatus.OnLost -> {
                        Log.d("ssong-develop","onLost ${networkStatus.network}")
                    }
                    NetworkChecker.NetworkStatus.OnUnAvailable -> {
                        Log.d("ssong-develop","onUnAvailable")
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