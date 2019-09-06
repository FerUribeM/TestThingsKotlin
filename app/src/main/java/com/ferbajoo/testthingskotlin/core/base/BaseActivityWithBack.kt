package com.ferbajoo.testthingskotlin.core.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ferbajoo.testthingskotlin.core.koin.injectFeature
import com.ferbajoo.testthingskotlin.core.utils.AndroidDisposable

open class BaseActivityWithBack : AppCompatActivity() {

    private val subscriptions = AndroidDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectFeature()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.dispose()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}