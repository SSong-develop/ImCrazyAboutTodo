package com.ssong_develop.core_data.repository

import com.ssong_develop.model.WifiAddress
import kotlinx.coroutines.flow.Flow

interface WifiAddressRepository {

    fun getWifiAddressStream() : Flow<WifiAddress?>

    suspend fun insertWifiAddress(wifiAddress: WifiAddress)

    suspend fun deleteWifiAddress(wifiAddress: WifiAddress)
}