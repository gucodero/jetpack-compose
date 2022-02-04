package com.gucodero.compose

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        startKoin {
            modules(AppModule)
        }
        super.onCreate()
    }

}