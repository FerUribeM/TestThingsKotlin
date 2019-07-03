package com.ferbajoo.testthingskotlin

import android.os.Bundle
import android.os.Handler
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.amplemind.presentation.Resource
import com.amplemind.presentation.interfaces.OnEvents
import com.ferbajoo.annotation_test.GreetingGenerator
import com.ferbajoo.testthingskotlin.activities.main.ActivitiesAdapter
import com.ferbajoo.testthingskotlin.activities.main.ItemClassModelViewModel
import com.ferbajoo.testthingskotlin.activities.main.MainViewModel
import com.ferbajoo.testthingskotlin.core.base.BaseActivity
import com.ferbajoo.testthingskotlin.core.extensions.callActivityInMain
import com.ferbajoo.testthingskotlin.core.extensions.getToolbar
import com.ferbajoo.testthingskotlin.core.extensions.showError
import com.ferbajoo.testthingskotlin.core.extensions.showProgress
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.viewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModel()

    private val adapter = ActivitiesAdapter()

    @GreetingGenerator
    class createClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadActivities()

        setupAdapter()

        setupObserver()

        (ic_toolbar as Toolbar).getToolbar(this, "Test Things", false)
    }

    private fun loadActivities() {
        viewModel.loadActivities(GlobalClasses().getAllClasses())
    }

    private fun setupObserver() {
        viewModel.onListActivities().observe(this, Observer { setData(it) })
    }

    private fun setData(result: Resource<MutableList<ItemClassModelViewModel>>) {
        la_loader.showProgress(result.state)
        result.message?.let {
            showError(it)
            return
        }
        result.data?.let {
            adapter.setData(it)
        }
    }

    private fun setupAdapter() {
        rv_activites.adapter = adapter
        adapter.setListener(object : OnEvents<ItemClassModelViewModel> {
            override fun onClickListener(data: ItemClassModelViewModel, type: Int) {
                callActivityInMain(data.name)
            }
        })
    }

}
