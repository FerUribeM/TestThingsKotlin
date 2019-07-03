package com.ferbajoo.testthingskotlin.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ferbajoo.annotation_test.Foo
import com.ferbajoo.testthingskotlin.R
import com.ferbajoo.testthingskotlin.core.extensions.getToolbar
import kotlinx.android.synthetic.main.activity_jstest_layout.*

@Foo(
    name = "JSTestActivity",
    value = "Prueba para funciones javaScript en Android",
    drawable = R.drawable.ic_launcher_background
)
class JSTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jstest_layout)

        (ic_toolbar as Toolbar).getToolbar(this, "JavaScript")

        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        wb_javascript.settings.javaScriptEnabled = true

        runOnUiThread {
            wb_javascript.loadUrl(getString(R.string.WRITE_ON_HTML))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

}
