package com.ferbajoo.testthingskotlin.core.koin

import com.ferbajoo.testthingskotlin.activities.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        viewModelModules
    )
}


val viewModelModules: Module = module {
    viewModel { MainViewModel() }
}