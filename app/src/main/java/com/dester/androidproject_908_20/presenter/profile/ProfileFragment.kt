package com.dester.androidproject_908_20.presenter.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.androidproject_908_20.databinding.FragmentProfileBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment

class ProfileFragment : BaseFragment<ProfileVM>() {

    lateinit var binding:FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        viewModel = ProfileVM()
        return binding.root
    }
}