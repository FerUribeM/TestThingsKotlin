package com.ferbajoo.testthingskotlin.core.extensions

import android.content.Context
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity

/**
 * @param context get current fragment or activity
 * @return true if detect device in landscape
 */
fun AppCompatActivity.isLanscape(): Boolean {
    val getOrient = this.windowManager.defaultDisplay
    val orientation: Boolean
    val size = Point()
    getOrient.getSize(size)
    val width = size.x
    val height = size.y
    orientation = width != height && width >= height
    return orientation
}