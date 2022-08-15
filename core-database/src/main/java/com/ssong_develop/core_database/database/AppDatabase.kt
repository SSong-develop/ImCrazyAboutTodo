package com.ssong_develop.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ssong_develop.core_database.dao.MacAddressDao
import com.ssong_develop.core_database.dao.ProfileDao
import com.ssong_develop.core_database.dao.ResultDao
import com.ssong_develop.core_database.dao.TodoDao
import com.ssong_develop.core_database.entity.MacAddressEntity
import com.ssong_develop.core_database.entity.ProfileEntity
import com.ssong_develop.core_database.entity.ResultEntity
import com.ssong_develop.core_database.entity.TodoEntity

@Database(
    entities = [
        MacAddressEntity::class,
        TodoEntity::class,
        ResultEntity::class,
        ProfileEntity::class
    ],
    version = 3,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun macAddressDao(): MacAddressDao
    abstract fun profileDao(): ProfileDao
    abstract fun resultDao(): ResultDao
    abstract fun todoDao(): TodoDao
}