package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.WifiAddressEntity
import com.ssong_develop.model.WifiAddress

fun WifiAddress.asEntityModel() = WifiAddressEntity(
    wifiAddress = wifiAddress,
    createdAt = createdAt
)