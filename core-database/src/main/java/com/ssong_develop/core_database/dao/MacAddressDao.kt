package com.ssong_develop.core_database.dao

import androidx.room.*

@Dao
interface MacAddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMacAddress(macAddress: String)

    @Query("SELECT * FROM mac_address where macAddress = :macAddress_")
    fun getMacAddress(macAddress_: String)

    // FIXME ssong-develop 에러가 날 수 있어요요
    @Delete
    fun deleteMacAddress()
}