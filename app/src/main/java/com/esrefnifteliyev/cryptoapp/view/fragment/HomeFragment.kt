package com.esrefnifteliyev.cryptoapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.esrefnifteliyev.cryptoapp.R
import com.esrefnifteliyev.cryptoapp.databinding.FragmentHomeBinding
import com.esrefnifteliyev.cryptoapp.view.adapter.CoinAdapter
import com.esrefnifteliyev.cryptoapp.viewmodel.BaseViewModel
import com.esrefnifteliyev.cryptoapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel : HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cryptoLiveData.observe(viewLifecycleOwner){coins ->
           val adapter = CoinAdapter(requireContext(),coins)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)


            adapter.setOnClickData { coin ->
                 val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(coin.id)
                 findNavController().navigate(action)
            }

        }
    }
}