package com.example.assessment2v5
//Application Class

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    var isUserLoggedIn: Boolean = false
}