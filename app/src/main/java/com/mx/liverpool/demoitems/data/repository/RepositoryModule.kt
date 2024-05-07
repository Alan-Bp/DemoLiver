package com.mx.liverpool.demoitems.data.repository

import com.mx.liverpool.demoitems.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideItemsRepository(apiService: ApiService): ItemsRepository {
        return ItemsRepository(apiService)
    }
}