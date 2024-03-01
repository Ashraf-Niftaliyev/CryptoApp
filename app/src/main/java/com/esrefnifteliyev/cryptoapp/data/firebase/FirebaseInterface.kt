package com.esrefnifteliyev.cryptoapp.data.firebase

interface FirebaseInterface {

    suspend fun createUser(email : String, password: String,onSuccess: () -> Unit, onFail: (Exception) -> Unit,)


    suspend fun singInUser(email: String,password: String,onSuccess: () -> Unit, onFail: (Exception) -> Unit,)

}