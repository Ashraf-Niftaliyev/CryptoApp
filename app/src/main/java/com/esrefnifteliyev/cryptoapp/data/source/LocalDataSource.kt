package com.esrefnifteliyev.cryptoapp.data.source

import com.esrefnifteliyev.cryptoapp.data.local.room.AppDao
import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(private val dao: AppDao) {

    suspend fun getAllCryptos() = withContext(Dispatchers.IO){
        dao.getAllCryptos()
    }

    suspend fun insertCrypto(cryptoEntity: CryptoEntity) = withContext(Dispatchers.IO){
        dao.insertCrypto(cryptoEntity)
    }

    suspend fun deleteCrypto(cryptoEntity: CryptoEntity) = withContext(Dispatchers.IO){
        dao.deleteCrypto(cryptoEntity)
    }

}