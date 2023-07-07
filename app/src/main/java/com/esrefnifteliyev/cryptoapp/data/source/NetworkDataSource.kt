package com.esrefnifteliyev.cryptoapp.data.source

import com.esrefnifteliyev.cryptoapp.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkDataSource(private val ns : NetworkService) {

    suspend fun getAllCoins() = withContext(Dispatchers.IO){
        ns.getAllCryptos()
    }

}