package com.esrefnifteliyev.cryptoapp.domain.repository

import com.esrefnifteliyev.cryptoapp.data.firebase.FirebaseInterface
import com.esrefnifteliyev.cryptoapp.data.source.FirebaseDataSource

class FirebaseRepository(private val fds: FirebaseDataSource) : FirebaseInterface {
    override suspend fun createUser(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail: (Exception) -> Unit
    ) {
         fds.createUser(email,password,onSuccess,onFail)
    }

    override suspend fun singInUser(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail: (Exception) -> Unit
    ) {
        fds.signInUSer(email,password, onSuccess, onFail)
    }

    override suspend fun resetPassword(
        email: String,
        onSuccess: () -> Unit,
        onFail: (Exception) -> Unit
    ) {
        fds.resetPassword(email, onSuccess, onFail)
    }

    override suspend fun signOut(){
        fds.signOut()
    }


}