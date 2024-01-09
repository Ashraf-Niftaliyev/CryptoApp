package com.esrefnifteliyev.cryptoapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.data.model.CryptoModel
import com.esrefnifteliyev.cryptoapp.databinding.RecyclerSavedItemBinding

class SavedAdapter(private val context: Context, private val list: List<CryptoEntity>) : RecyclerView.Adapter<SavedAdapter.SavedViewHolder>() {

    var onClick : (CryptoEntity) -> Unit = {

    }

    inner class SavedViewHolder(val binding: RecyclerSavedItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val binding = RecyclerSavedItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return SavedViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        val view = holder.binding
        val saved = list[position]


        val lowPrice = "%.2f".format(saved.dailyLow)
        val highPrice = "%.2f".format(saved.dailyHigh)
        val currentPrice = "%.2f".format(saved.currentPrice)

        Glide.with(context).load(saved.image).into(view.savedImageView)

        view.savedTitleText.text = saved.name
        view.savedLastLimitsText.text = "High: $highPrice, Low: $lowPrice"
        view.savedPriceText.text = "Price: $currentPrice$ "

        view.deleteSaved.setOnClickListener {
            onClick.invoke(saved)
        }


    }

    fun onClickData(action: (CryptoEntity) -> Unit){
        onClick = action
    }


}