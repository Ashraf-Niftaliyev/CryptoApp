package com.esrefnifteliyev.cryptoapp.domain.repository

import com.esrefnifteliyev.cryptoapp.data.source.NetworkDataSource

class NetworkRepository(private val nds: NetworkDataSource) {

    suspend fun getAllCoins() = nds.getAllCoins()

}