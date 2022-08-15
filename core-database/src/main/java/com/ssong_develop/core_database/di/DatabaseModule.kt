package com.ssong_develop.core_database.di

import android.content.Context
import androidx.room.Room
import com.ssong_develop.core_database.database.AppDatabase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "im_crazy_about_todo_database").build()

}