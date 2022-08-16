package com.ssong_develop.feature_mac_address

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.core_data.repository.WifiAddressRepository
import com.ssong_develop.model.WifiAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WifiAddressViewModel @Inject constructor(
    private val wifiAddressRepository: WifiAddressRepository
) : ViewModel() {

    fun saveWifiAddress(wifiAddress: WifiAddress) = viewModelScope.launch {
        wifiAddressRepository.insertWifiAddress(wifiAddress)
    }
}