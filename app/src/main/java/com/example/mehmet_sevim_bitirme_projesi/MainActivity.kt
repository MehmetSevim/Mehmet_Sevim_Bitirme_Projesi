package com.example.mehmet_sevim_bitirme_projesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomDB
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomEntitiy
import com.example.mehmet_sevim_bitirme_projesi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val getTripsDatabase = RoomDB.getTripsDatabase(this)

        //val tripModel = RoomEntitiy(1, "hotel","hotel","hotel","hotel","hotel","hotel")
       // getTripsDatabase?.tripDao()?.addTrip(tripModel)

        val students: List<RoomEntitiy> =
            getTripsDatabase?.tripDao()?.getFavourites() as ArrayList<RoomEntitiy>

        students.forEach {

            Log.v("Mehmet",it.title)
        }

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.apply {
            val navHostFragment = supportFragmentManager
                .findFragmentById(fragmentContainerView.id) as NavHostFragment
            bottomNavigationView3.setItemIconTintList(null);
            NavigationUI.setupWithNavController(activityMainBinding.bottomNavigationView3,navHostFragment.navController)
        }

    }
}