package com.ferbajoo.testthingskotlin.core.extensions

import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.amplemind.presentation.ResourceState
import com.ferbajoo.testthingskotlin.R


fun LottieAnimationView.showProgress(state: ResourceState?) {
    state.let {
        when (it) {
            ResourceState.LOADING -> {
                this.visible()
                this.playAnimation()
            }
            ResourceState.ERROR,
            ResourceState.SUCCESS -> {
                this.gone()
                this.cancelAnimation()
            }
        }
    }
}


fun View.showView(show: Boolean) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Context.showError(error: String, title: String? = null) {
    AlertDialog.Builder(this)
        .setTitle(if (title != null) title else getString(R.string.app_name))
        .setMessage(error)
        .setPositiveButton(getString(android.R.string.ok)) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }.show()
}

fun Toolbar.getToolbar(activity: AppCompatActivity, title: String, showHome: Boolean = true) {
    activity.setSupportActionBar(this)
    activity.supportActionBar?.let {
        it.title = title
        if (showHome) {
            it.setDisplayHomeAsUpEnabled(true)
        }
        this.setTitleTextColor(ContextCompat.getColor(activity, android.R.color.white))
    }
}

