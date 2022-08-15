package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.WifiAddress

@Entity(tableName = "wifi_address")
data class WifiAddressEntity(
    // Local DateTime
    @PrimaryKey
    val wifiAddress: String,
    val createdAt: String
)

fun WifiAddressEntity.asExternalModel() = WifiAddress(
    wifiAddress = wifiAddress,
    createdAt = createdAt
)