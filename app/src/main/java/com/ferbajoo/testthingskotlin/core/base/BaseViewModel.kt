package com.ferbajoo.testthingskotlin.core.base

import androidx.lifecycle.ViewModel
import com.ferbajoo.testthingskotlin.core.utils.AndroidDisposable

open class BaseViewModel : ViewModel() {

    val subscriptions = AndroidDisposable()

    override fun onCleared() {
        subscriptions.dispose()
        super.onCleared()
    }

}