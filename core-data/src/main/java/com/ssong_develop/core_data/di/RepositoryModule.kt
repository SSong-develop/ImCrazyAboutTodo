package com.ssong_develop.core_data.di

import com.ssong_develop.core_data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindTodoOfflineRepository(todoOfflineRepository: TodoOfflineRepository): TodoRepository

    @Binds
    fun bindProfileOfflineRepository(profileOfflineRepository: ProfileOfflineRepository): ProfileRepository

    @Binds
    fun bindResultOfflineRepository(resultOfflineRepository: ResultOfflineRepository): ResultOfflineRepository
}