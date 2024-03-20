package com.esrefnifteliyev.cryptoapp.view.fragment

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
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

        binding.haveAccount.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
        }


        binding.registerNameEdit.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                binding.registerNameEdit.setBackgroundResource(R.drawable.login_focus_shape)
            }else{
                binding.registerNameEdit.setBackgroundResource(R.drawable.login_edittext_shape)
            }

        }

        binding.registerEmailEdit.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                binding.registerEmailEdit.setBackgroundResource(R.drawable.login_focus_shape)
            }else{
                binding.registerEmailEdit.setBackgroundResource(R.drawable.login_edittext_shape)
            }

        }

        binding.registerPasswordEdit.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                binding.registerPasswordEdit.setBackgroundResource(R.drawable.login_focus_shape)
            }else{
                binding.registerPasswordEdit.setBackgroundResource(R.drawable.login_edittext_shape)
            }

        }


        fun togglePasswordVisibility(passwordEditText: EditText){
            val selectionStart = passwordEditText.selectionStart
            val selectionEnd = passwordEditText.selectionEnd

            if (passwordEditText.transformationMethod is PasswordTransformationMethod){
                passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
            }

            passwordEditText.setSelection(selectionStart,selectionEnd)

        }

        binding.registerPasswordEdit.setOnClickListener {

            togglePasswordVisibility(binding.registerPasswordEdit)

            if (binding.registerPasswordEdit.transformationMethod is PasswordTransformationMethod){
                binding.visibilityPassword.setImageResource(R.drawable.visibility_off)
            }else{
                binding.visibilityPassword.setImageResource(R.drawable.visibility_on)
            }

        }



    }
}