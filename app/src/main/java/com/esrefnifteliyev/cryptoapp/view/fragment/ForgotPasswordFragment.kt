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
import com.esrefnifteliyev.cryptoapp.databinding.FragmentForgotPasswordBinding
import com.esrefnifteliyev.cryptoapp.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendButton.setOnClickListener {
            var email = binding.editReset.text.toString()

            registerViewModel.resetPassword(email, onSuccess = {
                Toast.makeText(requireContext(),"Success,Check your email inbox",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.loginFragment)
            }, onFail = {
                Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
            })
        }

    }


}