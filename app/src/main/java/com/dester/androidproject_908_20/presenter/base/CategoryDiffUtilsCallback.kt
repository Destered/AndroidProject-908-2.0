package com.dester.androidproject_908_20.presenter.base

import androidx.recyclerview.widget.DiffUtil
import com.dester.androidproject_908_20.data.api.response.BaseCategoryData


class CategoryDiffUtilCallback(oldList: List<BaseCategoryData>, newList: List<BaseCategoryData>) :
    DiffUtil.Callback() {
    private val oldList: List<BaseCategoryData> = oldList
    private val newList: List<BaseCategoryData> = newList
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProduct: BaseCategoryData = oldList[oldItemPosition]
        val newProduct: BaseCategoryData = newList[newItemPosition]
        return oldProduct.id == newProduct.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProduct: BaseCategoryData = oldList[oldItemPosition]
        val newProduct: BaseCategoryData = newList[newItemPosition]
        return (oldProduct.name == newProduct.name)
    }

}