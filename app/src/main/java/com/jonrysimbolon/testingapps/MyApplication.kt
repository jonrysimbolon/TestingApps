package com.jonrysimbolon.testingapps

import android.app.Application
import com.jonrysimbolon.testingapps.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            fragmentFactory()
            modules(
                homeModule
            )
        }
    }
}