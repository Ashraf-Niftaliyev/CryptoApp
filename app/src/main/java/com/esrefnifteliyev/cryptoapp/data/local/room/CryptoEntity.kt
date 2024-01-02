package com.esrefnifteliyev.cryptoapp.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("crypto_table")
data class CryptoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var currentPrice: Double,
    var dailyHigh: Double,
    var dailyLow: Double,
    var totalVolume: String,
    var change: String,
)
