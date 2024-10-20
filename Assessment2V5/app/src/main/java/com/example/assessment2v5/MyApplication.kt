package com.example.assessment2v5
/*import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("nit3213", "Application onCreate was called")
    }
}*/

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    var isUserLoggedIn: Boolean = false
}