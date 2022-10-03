package com.example.mehmet_sevim_bitirme_projesi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: Application()  {
    override fun onCreate() {
        super.onCreate()
    }
}