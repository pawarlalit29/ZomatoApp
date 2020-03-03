package com.lalitp.zomatoapp.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate


class ZomatoApplication : Application() {
    companion object {
        lateinit var instance: ZomatoApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

    }

}