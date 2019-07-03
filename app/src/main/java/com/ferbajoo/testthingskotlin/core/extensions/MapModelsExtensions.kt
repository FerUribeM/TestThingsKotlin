package com.ferbajoo.testthingskotlin.core.extensions

import com.ferbajoo.testthingskotlin.activities.main.ItemClassModelViewModel
import com.ferbajoo.testthingskotlin.core.models.ClassModel

fun MutableList<ClassModel>.mapToActivitiesViewModel() = map {
    it.mapToItemViewModel()
}

fun ClassModel.mapToItemViewModel() = ItemClassModelViewModel(this)