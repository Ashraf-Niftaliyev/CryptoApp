package com.esrefnifteliyev.cryptoapp.view.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.esrefnifteliyev.cryptoapp.databinding.FragmentUserBinding
import com.google.android.material.snackbar.Snackbar

class UserFragment : Fragment() {
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var actionLauncher: ActivityResultLauncher<Intent>
    private var image: Uri? = null
    private lateinit var binding: FragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerPermission()

        binding.personImage.setOnClickListener {
             check(it)
        }

    }

    fun check(view: View){
        if (
            ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                Snackbar.make(view,"Permission needed",Snackbar.LENGTH_LONG).setAction("Give Permission"){
                    permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }.show()
            }else{
                permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }


        }

        else {
            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            actionLauncher.launch(intent)
        }
    }

    fun registerAction(){
        actionLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
                if (result.resultCode == RESULT_OK){
                    val d = result.data
                    d?.let { intentResult ->
                        intentResult.data?.let {
                            image = it
                            Glide.with(requireContext())
                                .load(image)
                                .into(binding.personImage)
                        }
                    }
                }
            }
    }

    fun registerPermission(){
        registerAction()
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()){ result ->
                if (result){
                    val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    actionLauncher.launch(intent)
                }
                else{
                    Toast.makeText(requireContext(),"Permission denied",Toast.LENGTH_LONG).show()
                }
            }
    }


}