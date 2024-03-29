package com.esrefnifteliyev.cryptoapp.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel
import com.esrefnifteliyev.cryptoapp.domain.repository.LocalRepository
import com.esrefnifteliyev.cryptoapp.domain.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val networkRepo: NetworkRepository,
    private val localRepo: LocalRepository,
): BaseViewModel() {

    private val _cryptoLiveData = MutableLiveData<CryptoModel>()
    val cryptoLiveData get() = _cryptoLiveData


    init {
        getAllCryptos()
    }


    fun getFilteredCoins(coinId: String = "bitcoin"){
        viewModelScope.launch {
            _cryptoLiveData.value = networkRepo.getFilteredCoins(coinId).first()
        }
    }

    private fun getAllCryptos(){
        viewModelScope.launch {
            localRepo.getAllCryptos()
        }
    }

    fun insertCrypto(cryptoEntity: CryptoEntity){
        viewModelScope.launch {
            localRepo.insertCrypto(cryptoEntity)
        }
    }

    fun deleteCrypto(cryptoEntity: CryptoEntity){
        viewModelScope.launch {
            localRepo.deleteCrypto(cryptoEntity)
        }
    }



    fun numberFormatted(volume: String) : String = if (volume.length > 12){
        "${"%.2f".format(volume.toDouble()/1000000000)} B"
    }else if (volume.length in 10..12){
        "${"%.2f".format(volume.toDouble()/1000000)} M"
    }else if(volume.length in 8..10){
        "${"%.2f".format(volume.toDouble()/1000)} K"
    }else{
        volume
    }


    fun changeNumberFormatted(change:String): String = if (change.length > 4){
        "%.4f".format(change.toDouble())
    }else{
        change
    }


}

