package com.ferbajoo.testthingskotlin.core.base

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { androidContext(this@MyApp) }
    }

}