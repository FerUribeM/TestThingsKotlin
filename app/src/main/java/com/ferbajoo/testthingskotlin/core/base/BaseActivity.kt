package com.ferbajoo.testthingskotlin.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ferbajoo.testthingskotlin.core.koin.injectFeature
import com.ferbajoo.testthingskotlin.core.utils.AndroidDisposable

open class BaseActivity : AppCompatActivity() {

    val subscriptions = AndroidDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectFeature()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.dispose()
    }

}