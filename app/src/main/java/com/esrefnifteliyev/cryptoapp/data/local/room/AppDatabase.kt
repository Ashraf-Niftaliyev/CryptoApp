package com.esrefnifteliyev.cryptoapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel

@Database(entities = [CryptoEntity::class], version = 3)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): AppDao
}