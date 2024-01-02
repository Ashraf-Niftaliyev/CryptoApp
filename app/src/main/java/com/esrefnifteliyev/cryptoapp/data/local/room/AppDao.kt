package com.esrefnifteliyev.cryptoapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM crypto_table")
    fun getAllCryptos() : List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCrypto(cryptoEntity: CryptoEntity)

    @Delete
    fun deleteCrypto(cryptoEntity: CryptoEntity)

}