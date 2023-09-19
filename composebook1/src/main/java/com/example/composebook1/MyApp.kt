package com.example.composebook1

import android.app.Application
import com.example.composebook1.notification.createNotificationChannel

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel(this)
    }
}