package com.example.androidtesttask;

import android.app.Application;

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Play.initialize(applicationContext)
        initData()
    }

    private fun initData() {

        var i = 1 +1
    }
}
