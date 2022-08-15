package com.ssong_develop.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mac_address")
data class MacAddressEntity(
    // Local DateTime
    @PrimaryKey
    val macAddress: String,
    val createdAt: String
)
