package com.ssong_develop.core_data.repository

import com.ssong_develop.core_data.model.asEntityModel
import com.ssong_develop.core_database.dao.ProfileDao
import com.ssong_develop.core_database.entity.asExternalModel
import com.ssong_develop.model.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProfileOfflineRepository @Inject constructor(
    private val profileDao: ProfileDao
) : ProfileRepository {
    override fun getProfileStream(id: String): Flow<Profile> = profileDao.getProfile(id).map { entity -> entity.asExternalModel() }

    override fun insertProfile(profile: Profile) = profileDao.insertProfile(profile.asEntityModel())

    override fun deleteProfile(profile: Profile) = profileDao.deleteProfile(profile.asEntityModel())
}