package com.amplemind.presentation.extensions

import androidx.lifecycle.MutableLiveData
import com.amplemind.presentation.Resource
import com.amplemind.presentation.ResourceState

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(Resource(ResourceState.SUCCESS, data))

fun <T> MutableLiveData<Resource<T>>.setLoading() {
    postValue(Resource(ResourceState.LOADING, null))
}

fun <T> MutableLiveData<Resource<T>>.setError(message: String? = null) =
    postValue(Resource(ResourceState.ERROR, value?.data, message))