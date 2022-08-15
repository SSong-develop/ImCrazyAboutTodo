package com.ssong_develop.feature_profile

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
): ViewModel() {

}