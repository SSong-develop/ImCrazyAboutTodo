package com.ssong_develop.feature_chat

import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.ChattingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChattingViewModel @Inject constructor(
    private val chattingRepository: ChattingRepository
): ViewModel() {

}