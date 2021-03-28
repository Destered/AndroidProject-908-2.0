package com.dester.androidproject_908_20.presenter.category_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.dester.androidproject_908_20.databinding.FragmentCategoryListBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment
import com.dester.androidproject_908_20.data.api.CategoryRequest

class CategoryListFragment: BaseFragment<CategoryListVM>() {

    lateinit var binding:FragmentCategoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("dester/","onCreate")
        val request = arguments?.getParcelable("request") ?: CategoryRequest("character")
        Log.d("dester/","getRequest: ${request.requestType}")
        viewModel = CategoryListVM(lifecycleScope,request,this,{type,id -> openItem(type,id)})
        Log.d("dester/","SetVM")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("dester/","StartBinding")
        binding = FragmentCategoryListBinding.inflate(layoutInflater)
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@CategoryListFragment
            categoryRecyclerView.adapter = viewModel.itemListAdapter
            Log.d("dester/","AllSet")
            categoryRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (!recyclerView.canScrollVertically(1)){ //1 for down
                        viewModel.loadMoreData()
                    }
                }
            })
        }
        viewModel.initVM()
        return binding.root


    }

    private fun openItem(type:String, id:Int){
        val action = CategoryListFragmentDirections.actionCategoryListFragmentToDetailedInfoFragment(
            CategoryRequest(type,null,id)
        )
        navigationController.navigate(action)
    }



}