package com.esrefnifteliyev.cryptoapp.data.firebase

import com.esrefnifteliyev.cryptoapp.data.source.FirebaseDataSource
import com.esrefnifteliyev.cryptoapp.domain.repository.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseDataSource() = FirebaseDataSource()

    @Provides
    @Singleton
    fun provideFirebaseRepository(fds: FirebaseDataSource) = FirebaseRepository(fds) as FirebaseInterface


}