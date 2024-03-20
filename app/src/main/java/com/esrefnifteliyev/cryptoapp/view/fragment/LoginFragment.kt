package com.esrefnifteliyev.cryptoapp.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.esrefnifteliyev.cryptoapp.R
import com.esrefnifteliyev.cryptoapp.databinding.FragmentLoginBinding
import com.esrefnifteliyev.cryptoapp.view.activity.MainActivity
import com.esrefnifteliyev.cryptoapp.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
           val email = binding.loginEmailEdit.text.toString()
           val password = binding.loginPasswordEdit.text.toString()
            registerViewModel.signInUser(email,password, onSuccess = {
                val intent = Intent(requireActivity(),MainActivity::class.java)
                requireActivity().startActivity(intent)
            }, onFail = {
                 Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
            })
        }

        binding.dontHaveAccount.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }

    }

}