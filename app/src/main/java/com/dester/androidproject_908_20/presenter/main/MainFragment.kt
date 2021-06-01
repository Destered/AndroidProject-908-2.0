package com.dester.androidproject_908_20.presenter.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.androidproject_908_20.databinding.FragmentMainBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment
import com.dester.androidproject_908_20.presenter.data.UserInfo

class MainFragment : BaseFragment<MainVM>() {

    lateinit var binding: FragmentMainBinding
    lateinit var userData: UserInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)
        viewModel = MainVM(userData)
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@MainFragment
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userData = activity?.intent?.extras?.get("userData") as UserInfo
    }
}
