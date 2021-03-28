package com.dester.androidproject_908_20.presenter.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class CommonAdapter<T : ItemVM>(
        private val createViewHolderDelegate: (parent: ViewGroup, viewType: Int) -> ViewHolder<T>
) : RecyclerView.Adapter<ViewHolder<T>>() {

    private val items = mutableListOf<T>()

    fun setItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        this.items.add(0, item)
        notifyDataSetChanged()
    }

    fun addItems(items: List<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        return createViewHolderDelegate(parent, viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(position, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}