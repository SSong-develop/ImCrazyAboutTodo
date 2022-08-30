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
    override fun getChatStream(): Flow<List<Chat>> = chatDao.getChats().map { entityList ->
        entityList.map { entity -> entity.asExternalModel() }
    }

    override suspend fun insertChat(chat: Chat) = chatDao.insertChat(chat.asEntityModel())

    override suspend fun deleteChat(chat: Chat) = chatDao.deleteChat(chat.asEntityModel())
}