package com.dester.androidproject_908_20.presenter.base

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    open lateinit var viewModel: T

    val Fragment.navigationController
        get() = NavHostFragment.findNavController(this)


}