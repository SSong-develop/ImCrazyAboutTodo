package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ProfileEntity

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profileEntity: ProfileEntity)

    @Query("SELECT * FROM profile where id = :profileId")
    fun getProfile(profileId: String)

    // FIXME ssong-develop 에러가 날 수 있어요요
    @Delete
    fun deleteProfile()
}