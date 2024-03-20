package com.esrefnifteliyev.cryptoapp.data.source

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class FirebaseDataSource() {
     private val authLiveData = MutableLiveData<FirebaseAuth?>(Firebase.auth)
    suspend fun createUser(email: String, password: String, onSuccess: () -> Unit, onFail: (Exception) -> Unit) = withContext(Dispatchers.IO){
        authLiveData.value?.createUserWithEmailAndPassword(email,password)?.addOnSuccessListener {
            onSuccess()
        }?.addOnFailureListener { exception ->
            onFail(exception)
        }
    }

    suspend fun signInUSer(email: String, password: String, onSuccess: () -> Unit, onFail: (Exception) -> Unit) = withContext(Dispatchers.IO){
        authLiveData.value?.signInWithEmailAndPassword(email,password)?.addOnSuccessListener {
            onSuccess()
        }?.addOnFailureListener{ exception ->
            onFail(exception)
        }
    }

    suspend fun resetPassword(email: String, onSuccess: () -> Unit, onFail: (Exception) -> Unit) = withContext(Dispatchers.IO){
        authLiveData.value?.sendPasswordResetEmail(email)?.addOnSuccessListener {
            onSuccess()
        }?.addOnFailureListener { exception ->
            onFail(exception)
        }
    }

    suspend fun signOut() = withContext(Dispatchers.IO){
        authLiveData.value?.signOut()
    }

}