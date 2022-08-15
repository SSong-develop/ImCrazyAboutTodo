package com.ssong_develop.core_network.di

import android.content.Context
import com.ssong_develop.core_network.networkchecker.NetworkChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkCheckerModule {

    @Provides
    @Singleton
    fun provideNetworkChecker(@ApplicationContext context: Context) = NetworkChecker(context)
}