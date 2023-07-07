package com.esrefnifteliyev.cryptoapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel
import com.esrefnifteliyev.cryptoapp.databinding.RecyclerCoinItemBinding

class CoinAdapter(val context: Context, val list: List<CryptoModel>): RecyclerView.Adapter<CoinAdapter.CoinHolder>() {

    inner class CoinHolder(val binding: RecyclerCoinItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinHolder {
        val binding = RecyclerCoinItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CoinHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CoinHolder, position: Int) {
        val view = holder.binding
        val coin = list[position]

        Glide.with(context).load(coin.image).into(view.imageView)
        val lowPrice = "%.2f".format(coin.low_24h)
        val highPrice = "%.2f".format(coin.high_24h)
        val currentPrice = "%.2f".format(coin.current_price)

        view.titleText.text = coin.name
        view.lastLimitsText.text = "High: $highPrice, Low: $lowPrice"
        view.priceText.text = "Price: $currentPrice$ "
    }

}