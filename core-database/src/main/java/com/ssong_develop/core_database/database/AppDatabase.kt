package com.ssong_develop.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ssong_develop.core_database.dao.WifiAddressDao
import com.ssong_develop.core_database.dao.ChatDao
import com.ssong_develop.core_database.dao.TodoPhotoDao
import com.ssong_develop.core_database.dao.TodoDao
import com.ssong_develop.core_database.entity.WifiAddressEntity
import com.ssong_develop.core_database.entity.ChatEntity
import com.ssong_develop.core_database.entity.TodoPhotoEntity
import com.ssong_develop.core_database.entity.TodoEntity

@Database(
    entities = [
        WifiAddressEntity::class,
        TodoEntity::class,
        TodoPhotoEntity::class,
        ChatEntity::class
    ],
    version = 5,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun macAddressDao(): WifiAddressDao
    abstract fun profileDao(): ChatDao
    abstract fun resultDao(): TodoPhotoDao
    abstract fun todoDao(): TodoDao
}