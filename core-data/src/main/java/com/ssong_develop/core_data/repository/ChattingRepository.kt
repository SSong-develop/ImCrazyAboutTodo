package com.ssong_develop.core_data.repository

import com.ssong_develop.model.Chat
import kotlinx.coroutines.flow.Flow

interface ChattingRepository {

    fun getChatStream() : Flow<Chat>

    fun insertChat(chat: Chat)

    fun deleteChat(chat: Chat)
}