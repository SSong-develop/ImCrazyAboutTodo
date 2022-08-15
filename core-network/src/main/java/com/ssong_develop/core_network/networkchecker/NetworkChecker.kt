package com.ssong_develop.core_network.networkchecker

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class NetworkChecker @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @RequiresApi(Build.VERSION_CODES.N)
    val networkStatusFlow = callbackFlow<NetworkStatus> {
        trySend(NetworkStatus.Loading)

        val networkCallbackImpl = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(NetworkStatus.OnAvailable(network))
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                trySend(NetworkStatus.OnLosing(network,maxMsToLive))
            }

            override fun onLost(network: Network) {
                trySend(NetworkStatus.OnLost(network))
            }

            override fun onUnavailable() {
                trySend(NetworkStatus.OnUnAvailable)
            }

            /** no - option **/
            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
            }

            /** no - option **/
            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties)
            }

            /** no - option **/
            override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
                super.onBlockedStatusChanged(network, blocked)
            }
        }
        connectivityManager.registerDefaultNetworkCallback(networkCallbackImpl)

        awaitClose {
            connectivityManager.unregisterNetworkCallback(networkCallbackImpl)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    val isNetworkAvailable = connectivityManager.activeNetwork != null

    sealed class NetworkStatus {
        object Loading : NetworkStatus()
        data class OnAvailable(val network: Network) : NetworkStatus()
        data class OnLosing(val network: Network, val maxMsToLive: Int) : NetworkStatus()
        data class OnLost(val network: Network) : NetworkStatus()
        object OnUnAvailable : NetworkStatus()
        data class OnCapabilitiesChanged(
            val network: Network,
            val networkCapabilities: NetworkCapabilities
        ) : NetworkStatus()

        data class OnLinkPropertiesChanged(
            val network: Network,
            val linkProperties: LinkProperties
        ) : NetworkStatus()

        data class OnBlockedStatusChanged(
            val network: Network,
            val blocked: Boolean
        ) : NetworkStatus()
    }
}