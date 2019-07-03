package com.ferbajoo.testthingskotlin.core.extensions

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.callActivityInMain(name: String) {
    val packages = this.packageName
    val intent = Intent(Intent.ACTION_MAIN)
    intent.component = ComponentName(packages, "$packages.activities.$name")
    startActivity(intent)
}