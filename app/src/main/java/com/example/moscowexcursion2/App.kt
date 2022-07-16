package com.example.moscowexcursion2

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App: Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
        instance = this

    }



}