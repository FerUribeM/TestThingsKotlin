package com.ferbajoo.testthingskotlin.activities.main

import androidx.lifecycle.MutableLiveData
import com.amplemind.presentation.Resource
import com.amplemind.presentation.extensions.setError
import com.amplemind.presentation.extensions.setLoading
import com.amplemind.presentation.extensions.setSuccess
import com.ferbajoo.testthingskotlin.core.base.BaseViewModel
import com.ferbajoo.testthingskotlin.core.extensions.addTo
import com.ferbajoo.testthingskotlin.core.extensions.mapToActivitiesViewModel
import com.ferbajoo.testthingskotlin.core.models.ClassModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainViewModel : BaseViewModel() {

    private val listActivities = MutableLiveData<Resource<MutableList<ItemClassModelViewModel>>>()

    fun loadActivities(allClasses: MutableList<ClassModel>) {
        Observable
            .fromCallable { allClasses.mapToActivitiesViewModel() }
            .delay(3L, TimeUnit.SECONDS)
            .doOnSubscribe { listActivities.setLoading() }
            .subscribe({ data ->
                if (data.isNotEmpty()) {
                    listActivities.setSuccess(data.toMutableList())
                }
            }, {
                listActivities.setError(it.message)
            })
            .addTo(subscriptions)
    }

    fun onListActivities() = listActivities

}