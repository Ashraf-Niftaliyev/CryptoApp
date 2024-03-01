package com.esrefnifteliyev.cryptoapp.data.firebase

import com.esrefnifteliyev.cryptoapp.data.source.FirebaseDataSource
import com.esrefnifteliyev.cryptoapp.domain.repository.FirebaseRepository
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
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
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseDataSource(auth: FirebaseAuth) = FirebaseDataSource(auth)

    @Provides
    @Singleton
    fun provideFirebaseRepository(fds: FirebaseDataSource) = FirebaseRepository(fds) as FirebaseInterface


}