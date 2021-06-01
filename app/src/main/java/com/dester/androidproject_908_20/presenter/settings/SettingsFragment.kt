package com.dester.androidproject_908_20.presenter.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.androidproject_908_20.databinding.FragmentSettingsBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment

class SettingsFragment:BaseFragment<SettingsVM>() {

    lateinit var binding:FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater)
        viewModel = SettingsVM()
        return binding.root
    }
}