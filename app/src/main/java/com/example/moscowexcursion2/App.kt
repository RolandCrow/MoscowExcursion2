package com.example.moscowexcursion2

import android.app.Application
import com.example.moscowexcursion2.di.mainModule
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App: Application() {


    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            modules(mainModule)
        }
    }

}