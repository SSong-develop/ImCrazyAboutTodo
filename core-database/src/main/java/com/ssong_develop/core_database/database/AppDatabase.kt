package com.ssong_develop.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ssong_develop.core_database.dao.WifiAddressDao
import com.ssong_develop.core_database.dao.ProfileDao
import com.ssong_develop.core_database.dao.ResultDao
import com.ssong_develop.core_database.dao.TodoDao
import com.ssong_develop.core_database.entity.WifiAddressEntity
import com.ssong_develop.core_database.entity.ProfileEntity
import com.ssong_develop.core_database.entity.ResultEntity
import com.ssong_develop.core_database.entity.TodoEntity

@Database(
    entities = [
        WifiAddressEntity::class,
        TodoEntity::class,
        ResultEntity::class,
        ProfileEntity::class
    ],
    version = 4,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun macAddressDao(): WifiAddressDao
    abstract fun profileDao(): ProfileDao
    abstract fun resultDao(): ResultDao
    abstract fun todoDao(): TodoDao
}