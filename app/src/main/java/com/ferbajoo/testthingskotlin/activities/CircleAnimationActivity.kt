package com.ferbajoo.testthingskotlin.activities

import android.animation.Animator
import android.graphics.Point
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ferbajoo.annotation_test.Foo
import com.ferbajoo.testthingskotlin.R
import com.ferbajoo.testthingskotlin.core.base.BaseActivityWithBack
import com.ferbajoo.testthingskotlin.core.extensions.getToolbar
import com.ferbajoo.testthingskotlin.core.extensions.isLanscape
import com.ferbajoo.testthingskotlin.core.extensions.visible
import kotlinx.android.synthetic.main.activity_circle_animation.*

@Foo(
    name = "CircleAnimationActivity",
    value = "Animación menu circular en android",
    drawable = R.drawable.circle_animation
)
class CircleAnimationActivity : BaseActivityWithBack() {

    private var mBtnFloats = mutableListOf<ImageView>()
    private lateinit var mPoints: Array<Point>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_animation)

        (ic_toolbar as Toolbar).getToolbar(this, "Circle Animation")

        fillPoints()
        setupBtn()

        fab_father.setOnClickListener(floatClick)
    }

    private val floatClick = object : View.OnClickListener {
        private var state: Boolean = false
        override fun onClick(v: View?) {
            startCircleAnimation(0, state)
            state = !state
        }
    }

    private fun startCircleAnimation(position: Int, state: Boolean) {
        mBtnFloats[position].visible()
        mBtnFloats[position].clearAnimation()
        mBtnFloats[position].animate()
            .translationY((if (!state) mPoints[position].y else 0).toFloat())
            .translationX((if (!state) mPoints[position].x else 0).toFloat())
            .alpha((if (!state) 1 else 0).toFloat())
            .scaleX((if (!state) 1 else 0).toFloat())
            .scaleY((if (!state) 1 else 0).toFloat())
            .setDuration(500)
            .setListener(object : AbstractAnimatorListener() {
                override fun onAnimationEnd(animation: Animator) {
                    if (position <= mBtnFloats.size - 2) {
                        startCircleAnimation(position + 1, state)
                    }
                }
            })
            .start()
    }

    private fun fillPoints() {
        val land = isLanscape()
        mPoints = arrayOf(
            Point(if (land) -207 else -450, -0),
            Point(if (land) -470 else -340, if (land) -0 else -370),
            Point(if (land) -720 else 0, if (land) -0 else -480),
            Point(if (land) 270 else 360, if (land) -0 else -340),
            Point(if (land) 540 else 450, 0),
            Point(if (land) 770 else 370, if (land) 0 else 350),
            Point(2, if (land) -250 else 510),
            Point(if (land) 2 else -350, if (land) 275 else 350)
        )
    }

    private fun setupBtn() {
        mBtnFloats.apply {
            add(fab_child_one)
            add(fab_child_two)
            add(fab_child_three)
            add(fab_child_four)
            add(fab_child_five)
            add(fab_child_six)
            add(fab_child_seven)
            add(fab_child_eight)
        }
    }

    //region listener class abstract
    internal abstract inner class AbstractAnimatorListener : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {}

        override fun onAnimationEnd(animation: Animator) {}

        override fun onAnimationCancel(animation: Animator) {}

        override fun onAnimationRepeat(animation: Animator) {}
    }
    //endregion
}
