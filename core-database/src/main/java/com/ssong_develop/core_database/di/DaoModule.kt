package com.ssong_develop.core_database.di

import com.ssong_develop.core_database.database.AppDatabase
import dagger.Provides
import javax.inject.Singleton

object DaoModule {

    @Provides
    @Singleton
    fun provideMacAddressDao(database: AppDatabase) = database.macAddressDao()

    @Provides
    @Singleton
    fun provideProfileDao(database: AppDatabase) = database.profileDao()

    @Provides
    @Singleton
    fun provideResultDao(database: AppDatabase) = database.resultDao()

    @Provides
    @Singleton
    fun provideTodoDao(database: AppDatabase) = database.todoDao()
}