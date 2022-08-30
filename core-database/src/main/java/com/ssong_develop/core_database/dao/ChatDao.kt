package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ChatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChat(chatEntity: ChatEntity)

    @Query("SELECT * FROM chatting ")
    fun getChats() : Flow<List<ChatEntity>>

    @Delete
    fun deleteChat(chatEntity: ChatEntity)

    @Update
    fun updateChat(chatEntity: ChatEntity)
}