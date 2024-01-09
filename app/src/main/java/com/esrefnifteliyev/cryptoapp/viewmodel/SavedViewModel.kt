package com.esrefnifteliyev.cryptoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel
import com.esrefnifteliyev.cryptoapp.domain.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val localRepo: LocalRepository
): ViewModel() {

     val liveData = MutableLiveData<List<CryptoEntity>>()


    init {
        readDatabase()
    }

     private fun readDatabase(){
         viewModelScope.launch {
              liveData.value = localRepo.getAllCryptos()
         }
     }

    fun deleteItem(cryptoEntity: CryptoEntity){
        viewModelScope.launch {
             localRepo.deleteCrypto(cryptoEntity)
        }
    }

}