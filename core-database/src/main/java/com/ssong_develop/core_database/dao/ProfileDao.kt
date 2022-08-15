package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profileEntity: ProfileEntity)

    @Query("SELECT * FROM profile where id = :profileId")
    fun getProfile(profileId: String) : Flow<ProfileEntity>

    @Delete
    fun deleteProfile(profileEntity: ProfileEntity)
}