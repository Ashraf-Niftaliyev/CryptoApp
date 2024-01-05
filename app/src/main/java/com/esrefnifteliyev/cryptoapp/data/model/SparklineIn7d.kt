package com.esrefnifteliyev.cryptoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SparklineIn7d(
    val price: List<Double>
) : Parcelable