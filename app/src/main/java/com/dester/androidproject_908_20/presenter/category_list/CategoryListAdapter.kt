package com.dester.androidproject_908_20.presenter.category_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dester.androidproject_908_20.data.api.response.BaseCategoryData
import com.dester.androidproject_908_20.databinding.CategoryListItemBinding
import com.dester.androidproject_908_20.presenter.base.CategoryDiffUtilCallback
import java.util.*


class CategoryListAdapter(
    val clickOnItem: (String, Int) -> Unit
) : RecyclerView.Adapter<CategoryListAdapter.VH>() {

    private val items: ArrayList<BaseCategoryData> = arrayListOf()

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<BaseCategoryData>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setData(items: List<BaseCategoryData>){
        val categoryDiffUtilCallback = CategoryDiffUtilCallback(this.items, items)
        val categoryDiffResult = DiffUtil.calculateDiff(categoryDiffUtilCallback)

        this.setItems(items)
        categoryDiffResult.dispatchUpdatesTo(this)
    }

    fun addItem(item: BaseCategoryData) {
        val list = this.items
        list.add(item)
        setData(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryListItemBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position, items[position])
    }


    inner class VH(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, data: BaseCategoryData) {
            binding.name.text = data.name
           binding.root.setOnClickListener {
               clickOnItem.invoke(data.type, data.id)
           }



        }
    }
}