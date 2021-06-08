package com.robin.timer.base

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.robin.timer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
        MobileAds.initialize(this)
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    viewModelModule
                )
            )
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    companion object {
        @Volatile
        private var instance: BaseApplication? = null
    }
}