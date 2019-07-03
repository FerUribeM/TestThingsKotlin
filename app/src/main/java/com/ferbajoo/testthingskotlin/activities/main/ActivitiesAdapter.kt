package com.ferbajoo.testthingskotlin.activities.main

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.amplemind.presentation.adapter.GenericRecyclerAdapter
import com.amplemind.presentation.adapter.GenericRecyclerViewHolder
import com.amplemind.presentation.interfaces.OnEvents
import com.ferbajoo.testthingskotlin.BR
import com.ferbajoo.testthingskotlin.R

class ActivitiesAdapter : GenericRecyclerAdapter<ItemClassModelViewModel>() {

    private lateinit var listener: OnEvents<ItemClassModelViewModel>

    override fun getLayoutResId() = R.layout.item_list_classes_layout

    override fun getVariableId() = BR.itemModel

    override fun getViewHolder(binding: ViewDataBinding): RecyclerView.ViewHolder {
        val holder = GenericRecyclerViewHolder<ItemClassModelViewModel>(binding)
        holder.setListener(listener)
        return holder
    }

    fun setListener(listener: OnEvents<ItemClassModelViewModel>) {
        this.listener = listener
    }

}
