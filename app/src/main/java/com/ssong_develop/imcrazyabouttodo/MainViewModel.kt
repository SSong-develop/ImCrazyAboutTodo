package com.ssong_develop.imcrazyabouttodo

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.WifiAddressRepository
import com.ssong_develop.imcrazyabouttodo.ui.state.IcatScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val wifiAddressRepository: WifiAddressRepository
) : ViewModel() {

    val isRegisterWifiAddress = wifiAddressRepository.getWifiAddressStream().map { wifiAddress ->
        wifiAddress?.let {
            IcatScreenState.ENABLE_WIFI_ADDRESS
        } ?: IcatScreenState.UNABLE_WIFI_ADDRESS
    }
}