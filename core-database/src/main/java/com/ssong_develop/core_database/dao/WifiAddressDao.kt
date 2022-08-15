package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.WifiAddressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WifiAddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWifiAddress(WIfiAddressEntity : WifiAddressEntity)

    @Query("SELECT * FROM wifi_address")
    fun getWifiAddress() : Flow<WifiAddressEntity>

    @Delete
    fun deleteWifiAddress(WIfiAddressEntity: WifiAddressEntity)
}