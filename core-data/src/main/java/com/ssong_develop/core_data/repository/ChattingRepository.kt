package com.ssong_develop.core_data.repository

import com.ssong_develop.model.Chat
import kotlinx.coroutines.flow.Flow

interface ChattingRepository {

    fun getChatStream() : Flow<List<Chat>>

    suspend fun insertChat(chat: Chat)

    suspend fun deleteChat(chat: Chat)
}