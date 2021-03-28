package com.dester.androidproject_908_20.presenter.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ViewHolder<T : ItemVM>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, VM: ItemVM) {
        binding.setVariable(36, VM as T)
    }
}