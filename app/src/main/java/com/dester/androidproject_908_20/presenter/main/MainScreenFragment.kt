package com.dester.androidproject_908_20.presenter.main



import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.lifecycleScope
import com.dester.androidproject_908_20.databinding.FragmentMainBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment
import com.kotlinpermissions.KotlinPermissions
import com.dester.androidproject_908_20.data.api.CategoryRequest


class MainScreenFragment : BaseFragment<MainScreenVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainScreenVM(
            lifecycleScope,
            this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)

        binding.apply {
            lifecycleOwner = this@MainScreenFragment
            vm = viewModel
        }

        binding.charactersCard.card.setOnClickListener {
            askPermission(1)
        }

        binding.locationsCard.card.setOnClickListener {
            askPermission(2)
        }

        binding.episodesCard.card.setOnClickListener {
            askPermission(3)
        }

        Log.d("Course/FragmentMain", "Set Root")
        return binding.root
    }

    private fun navigateToCategory(categoryPosition:Int){
        viewModel.loadingVisibility.postValue(true)
        var categoryRequest: CategoryRequest? = null
        when(categoryPosition){
            1 -> categoryRequest = CategoryRequest("character")
            2 -> categoryRequest = CategoryRequest("location")
            3 -> categoryRequest = CategoryRequest("episode")
        }
        val action = categoryRequest?.let {
            MainScreenFragmentDirections.actionMainScreenFragmentToCategoryListFragment(it)
        }
        action?.let { navigationController.navigate(it) }
    }

    fun askPermission(category:Int){
        KotlinPermissions.with(requireActivity()) // where this is an FragmentActivity instance
            .permissions(Manifest.permission.INTERNET)
            .onAccepted { permissions ->
                navigateToCategory(category)
            }
            .onDenied { permissions ->
                askPermission(category)
            }
            .onForeverDenied { permissions ->
                askPermission(category)
            }
            .ask()
    }



}