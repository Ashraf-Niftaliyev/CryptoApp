package com.esrefnifteliyev.cryptoapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.esrefnifteliyev.cryptoapp.R
import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.databinding.FragmentDetailsBinding
import com.esrefnifteliyev.cryptoapp.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val detailsViewModel: DetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val data: DetailsFragmentArgs by navArgs()
         val coinId = data.coinId

          detailsViewModel.getFilteredCoins(coinId)
          detailsViewModel.cryptoLiveData.observe(viewLifecycleOwner){ coin ->
              Glide.with(requireContext()).load(coin.image).into(binding.cryptoImage)
              binding.cryptoName.text = "Name: ${coin.name}"
              binding.cryptoPrice.text = "Price: ${coin.current_price} $"
              binding.cryptoHigh.text = "High: ${coin.high_24h} $"
              binding.cryptoLow.text = "Low: ${coin.low_24h} $"

              val numberFormatted = detailsViewModel.numberFormatted(coin.total_volume.toString())
              binding.cryptoVolume.text = "Volume: $numberFormatted $"

              val changeNumberFormatted = detailsViewModel.changeNumberFormatted(coin.price_change_percentage_24h_in_currency.toString())
              binding.cryptoPercent.text = "Change: $changeNumberFormatted %"


              binding.saveCryptoButton.setOnClickListener {
                  val cryptoEntity = CryptoEntity(
                      id = 0,
                      name = coin.name,
                      currentPrice = coin.current_price,
                      dailyHigh = coin.high_24h,
                      dailyLow = coin.low_24h,
                      totalVolume = numberFormatted,
                      change = changeNumberFormatted,
                  )

                   detailsViewModel.insertCrypto(cryptoEntity)
              }
          }
    }

}