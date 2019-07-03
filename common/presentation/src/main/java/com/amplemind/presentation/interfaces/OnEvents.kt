package com.amplemind.presentation.interfaces

interface OnEvents<T>{
    fun onClickListener(data : T, type : Int = 0)
}