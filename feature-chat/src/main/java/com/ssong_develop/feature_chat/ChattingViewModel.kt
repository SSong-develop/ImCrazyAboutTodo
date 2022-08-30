package com.ssong_develop.feature_chat

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.core_common.di.IoDispatcher
import com.ssong_develop.core_data.repository.ChattingRepository
import com.ssong_develop.model.Chat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

// Chatting 지속시간은 최대 15일로 정해놓자
@HiltViewModel
class ChattingViewModel @Inject constructor(
    private val chattingRepository: ChattingRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): ViewModel() {

    val chattingList : Flow<List<Chat>> = chattingRepository.getChatStream()

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveChat(chatMessage: String) = viewModelScope.launch(ioDispatcher) {
        chattingRepository.insertChat(
            Chat(
                UUID.randomUUID().toString(),
                chatMessage,
                formatter.format(LocalDateTime.now())
            )
        )
    }
}