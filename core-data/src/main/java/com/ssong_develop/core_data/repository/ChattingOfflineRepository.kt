package com.ssong_develop.core_data.repository

import com.ssong_develop.core_data.model.asEntityModel
import com.ssong_develop.core_database.dao.ChatDao
import com.ssong_develop.core_database.entity.asExternalModel
import com.ssong_develop.model.Chat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChattingOfflineRepository @Inject constructor(
    private val chatDao: ChatDao
) : ChattingRepository {
    override fun getChatStream(id: String): Flow<Chat> = chatDao.getChats(id).map { entity -> entity.asExternalModel() }

    override fun insertChat(chat: Chat) = chatDao.insertChat(chat.asEntityModel())

    override fun deleteChat(chat: Chat) = chatDao.deleteChat(chat.asEntityModel())
}