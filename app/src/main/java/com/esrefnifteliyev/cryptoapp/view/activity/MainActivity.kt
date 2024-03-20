package com.esrefnifteliyev.cryptoapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
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

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNavigation,navHostFragment.navController,)



//        binding.bottomNavigation.setOnItemSelectedListener {
//
//
//            when (it.itemId) {
//                R.id.Home -> navController.navigate(R.id.homeFragment)
//                R.id.Saved -> navController.navigate(R.id.savedFragment)
//                R.id.User -> navController.navigate(R.id.userFragment)
//
//                else -> navController.navigate(R.id.homeFragment)
//
//            }
//
//            true
//
//        }


    }

}