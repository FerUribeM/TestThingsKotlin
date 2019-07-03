package com.amplemind.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.amplemind.presentation.interfaces.OnEvents

abstract class GenericRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = mutableListOf<T>()

    abstract fun getLayoutResId(): Int

    abstract fun getVariableId(): Int

    abstract fun getViewHolder(binding: ViewDataBinding): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            getLayoutResId(),
            parent,
            false
        )
        return getViewHolder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GenericRecyclerViewHolder<T>).bind(getVariableId(), list[position])
    }

    override fun getItemCount() = list.size

    fun setData(data: MutableList<T>) {
        this.list = data
        notifyDataSetChanged()
    }

    fun setData(position: Int, data: T) {
        this.list.add(position, data)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (list.isNotEmpty() && position != -1) {
            this.list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun getItem(position: Int): T? {
        if (list.isNotEmpty() && position != -1) {
            return this.list[position]
        }
        return null
    }

    fun getList() = this.list

    fun restoreItem(position: Int, item: T) {
        this.list.add(position, item)
        notifyItemInserted(position)
    }

}

class GenericRecyclerViewHolder<T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    private var item: T? = null

    private var listener: OnEvents<T>? = null

    fun bind(variableId: Int, item: T) {
        binding.setVariable(variableId, item)
        binding.executePendingBindings()
        this.item = item

        if (adapterPosition > -1) {
            binding.root.setOnClickListener {
                listener?.onClickListener(item)
            }
        }
    }

    fun getItem() = this.item

    fun setListener(listener: OnEvents<T>) {
        this.listener = listener
    }
}