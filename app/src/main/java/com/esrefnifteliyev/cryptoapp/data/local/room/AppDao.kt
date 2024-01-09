package com.esrefnifteliyev.cryptoapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel

@Dao
interface AppDao {

    @Query("SELECT * FROM crypto_table")
    suspend fun getAllCryptos() : List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCrypto(cryptoModel: CryptoEntity)

    @Delete
    suspend fun deleteCrypto(cryptoModel: CryptoEntity)

}