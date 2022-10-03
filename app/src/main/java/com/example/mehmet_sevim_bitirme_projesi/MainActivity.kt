package com.example.mehmet_sevim_bitirme_projesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mehmet_sevim_bitirme_projesi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        activityMainBinding.apply {
            val navHostFragment = supportFragmentManager
                .findFragmentById(fragmentContainerView.id) as NavHostFragment
            bottomNavigationView3.setItemIconTintList(null);
            NavigationUI.setupWithNavController(activityMainBinding.bottomNavigationView3,navHostFragment.navController)
        }

    }
}