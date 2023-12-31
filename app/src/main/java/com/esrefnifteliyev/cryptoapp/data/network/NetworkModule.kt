package com.esrefnifteliyev.cryptoapp.data.network

import com.esrefnifteliyev.cryptoapp.data.source.NetworkDataSource
import com.esrefnifteliyev.cryptoapp.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val BASE_URL = "https://api.coingecko.com/"

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkService::class.java)

    @Provides
    @Singleton
    fun provideNetworkDataSource(ns: NetworkService) = NetworkDataSource(ns)

    @Provides
    @Singleton
    fun provideNetworkRepository(nds: NetworkDataSource) = NetworkRepository(nds)

}