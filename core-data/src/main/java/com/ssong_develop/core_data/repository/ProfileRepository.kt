package com.ssong_develop.core_data.repository

import com.ssong_develop.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfileStream(id: String) : Flow<Profile>

    fun insertProfile(profile: Profile)

    fun deleteProfile(profile: Profile)
}