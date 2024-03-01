package com.esrefnifteliyev.cryptoapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.esrefnifteliyev.cryptoapp.R
import com.esrefnifteliyev.cryptoapp.databinding.FragmentRegisterBinding
import com.esrefnifteliyev.cryptoapp.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val email = binding.registerEmailEdit.text.toString()
            val password = binding.registerPasswordEdit.text.toString()

            registerViewModel.createUser(email,password, onSuccess = {
                findNavController().navigate(R.id.loginFragment)
            }, onFail = {
                 Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
            })
        }

    }
}