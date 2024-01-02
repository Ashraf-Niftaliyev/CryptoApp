package com.esrefnifteliyev.cryptoapp.domain.repository

import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.data.source.LocalDataSource

class LocalRepository(private val lds: LocalDataSource) {

    suspend fun getAllCryptos() = lds.getAllCryptos()

    suspend fun insertCrypto(cryptoEntity: CryptoEntity) = lds.insertCrypto(cryptoEntity)

    suspend fun deleteCrypto(cryptoEntity: CryptoEntity) = lds.deleteCrypto(cryptoEntity)

}