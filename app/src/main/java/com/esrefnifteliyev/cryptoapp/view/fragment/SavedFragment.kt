package com.esrefnifteliyev.cryptoapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.esrefnifteliyev.cryptoapp.R
import com.esrefnifteliyev.cryptoapp.data.local.room.CryptoEntity
import com.esrefnifteliyev.cryptoapp.databinding.FragmentSavedBinding
import com.esrefnifteliyev.cryptoapp.view.adapter.SavedAdapter
import com.esrefnifteliyev.cryptoapp.viewmodel.SavedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedFragment : Fragment() {
    private lateinit var binding: FragmentSavedBinding
    private val savedViewModel : SavedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        savedViewModel.liveData.observe(viewLifecycleOwner) { coins->

            val savedAdapter = SavedAdapter(requireContext(), coins)
            binding.savedRecyclerView.adapter = savedAdapter
            binding.savedRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

            savedAdapter.onClickData { coins ->
                val cryptoEntity = CryptoEntity(
                    id = coins.id,
                    name = coins.name,
                    currentPrice = coins.currentPrice,
                    dailyHigh = coins.dailyHigh,
                    dailyLow = coins.dailyLow,
                    totalVolume = coins.totalVolume,
                    change = coins.change,
                    image = coins.image
                )

                savedViewModel.deleteItem(cryptoEntity)

            }






        }





    }


}