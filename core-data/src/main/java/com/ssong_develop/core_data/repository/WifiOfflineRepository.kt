package com.ssong_develop.core_data.repository

import com.ssong_develop.core_data.model.asEntityModel
import com.ssong_develop.core_database.dao.WifiAddressDao
import com.ssong_develop.core_database.entity.asExternalModel
import com.ssong_develop.model.WifiAddress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WifiOfflineRepository @Inject constructor(
    private val wifiAddressDao: WifiAddressDao
) : WifiAddressRepository {
    override fun getWifiAddressStream(): Flow<WifiAddress> =
        wifiAddressDao.getWifiAddress().map { entity -> entity.asExternalModel() }

    override fun insertWifiAddress(wifiAddress: WifiAddress) = wifiAddressDao.insertWifiAddress(wifiAddress.asEntityModel())

    override fun deleteWifiAddress(wifiAddress: WifiAddress) = wifiAddressDao.deleteWifiAddress(wifiAddress.asEntityModel())
}