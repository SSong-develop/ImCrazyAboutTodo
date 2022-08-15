package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.MacAddressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MacAddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMacAddress(macAddressEntity : MacAddressEntity)

    @Query("SELECT * FROM mac_address where macAddress = :macAddress_")
    fun getMacAddress(macAddress_: String) : Flow<MacAddressEntity>

    @Delete
    fun deleteMacAddress(macAddressEntity: MacAddressEntity)
}