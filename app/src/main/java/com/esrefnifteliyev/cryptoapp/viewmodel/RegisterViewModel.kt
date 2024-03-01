package com.esrefnifteliyev.cryptoapp.viewmodel

import androidx.lifecycle.viewModelScope
import com.esrefnifteliyev.cryptoapp.data.firebase.FirebaseInterface
import com.esrefnifteliyev.cryptoapp.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseRepo: FirebaseInterface
) : BaseViewModel() {

    fun createUser(email: String, password: String, onSuccess: () -> Unit, onFail: (Exception) -> Unit){
        viewModelScope.launch {
            firebaseRepo.createUser(email, password, onSuccess, onFail)
        }
    }

    fun signInUser(email: String, password: String, onSuccess: () -> Unit, onFail: (Exception) -> Unit){
        viewModelScope.launch {
            firebaseRepo.singInUser(email, password, onSuccess, onFail)
        }
    }

}