package com.esrefnifteliyev.cryptoapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.esrefnifteliyev.cryptoapp.R
import com.esrefnifteliyev.cryptoapp.databinding.ActivityMainBinding
import com.esrefnifteliyev.cryptoapp.view.fragment.DetailsFragment
import com.esrefnifteliyev.cryptoapp.view.fragment.HomeFragment
import com.esrefnifteliyev.cryptoapp.view.fragment.SavedFragment
import com.esrefnifteliyev.cryptoapp.view.fragment.UserFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.Home -> replaceFragment(HomeFragment())
                R.id.Saved -> replaceFragment(SavedFragment())
                R.id.User -> replaceFragment(UserFragment())

                else -> {

                }
            }

            true

        }

    }

    private fun replaceFragment(fragment:Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()

    }


}