package com.ferbajoo.testthingskotlin.activities

import android.graphics.Color
import android.os.Bundle
import android.util.Log.e
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.ferbajoo.annotation_test.Foo
import com.ferbajoo.testthingskotlin.R
import com.ferbajoo.testthingskotlin.core.base.BaseActivityWithBack
import com.ferbajoo.testthingskotlin.core.extensions.getToolbar
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_graphics.*
import java.util.*

@Foo(
    name = "GraphicsActivity",
    value = "Sparkline en Android",
    drawable = R.drawable.sparkline
)
class GraphicsActivity : BaseActivityWithBack() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphics)

        (ic_toolbar as Toolbar).getToolbar(this, "Graphics")

        chart.setPinchZoom(false)
        chart.setTouchEnabled(false)
        chart.description.isEnabled = false
        chart.legend.isEnabled = false

        chart.animateX(2500)
        setData(5, 1f)
    }


    private fun setData(count: Int, range: Float) {

        val yVals1 = ArrayList<Entry>()

        yVals1.add(Entry(1f, 4.0f))
        yVals1.add(Entry(2f, 3.0f))
        yVals1.add(Entry(3f, 5.0f))
        yVals1.add(Entry(4f, 4.0f))
        yVals1.add(Entry(5f, 5.0f))
        yVals1.add(Entry(6f, 4.0f))
        yVals1.add(Entry(7f, 2.0f))
        yVals1.add(Entry(8f, 5.0f))
        yVals1.add(Entry(9f, 6.0f))
        yVals1.add(Entry(10f, 4.0f))

        // create a dataset and give it a type
        val set1 = LineDataSet(yVals1, "")

        set1.axisDependency = YAxis.AxisDependency.LEFT
        set1.color = ContextCompat.getColor(this, android.R.color.holo_red_dark)
        set1.lineWidth = 2f
        set1.fillAlpha = 65
        set1.setDrawCircleHole(false)
        set1.setDrawCircles(false)
        set1.setDrawValues(false)
        set1.mode = LineDataSet.Mode.CUBIC_BEZIER

// create a data object with the datasets
        val data = LineData(set1)

// set data
        chart.data = data
    }

}
