package com.ferbajoo.testthingskotlin.core.extensions

import android.view.View
import com.ferbajoo.testthingskotlin.core.utils.AndroidDisposable
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit


fun View.addThrottle(duration: Long = 2L): Observable<Any> {
    return RxView.clicks(this).throttleFirst(duration, TimeUnit.SECONDS)
}

fun Disposable.addTo(androidDisposable: AndroidDisposable): Disposable = apply { androidDisposable.add(this) }