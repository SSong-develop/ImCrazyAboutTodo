package com.ssong_develop.feature_chat

import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.ChattingRepository
import com.ssong_develop.model.Chat
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChattingViewModel @Inject constructor(
    private val chattingRepository: ChattingRepository
): ViewModel() {

    val chattingList = chattingRepository.getChatStream()

    val fakeChatList = mutableListOf<Chat>(
        Chat("1","안녕","123"),
        Chat("2","안녕1","1232"),
        Chat("3","안녕2","1233"),
        Chat("4","안녕3","1234"),
        Chat("5","안녕4","1235")
    )

}