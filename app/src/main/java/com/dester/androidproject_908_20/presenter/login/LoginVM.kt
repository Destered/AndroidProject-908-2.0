package com.dester.androidproject_908_20.presenter.login


import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.dester.androidproject_908_20.presenter.base.BaseViewModel


class LoginVM(
    lifecycleScope: LifecycleCoroutineScope,
    owner: LifecycleOwner,
) : BaseViewModel() {
    val loadingVisibility = MutableLiveData(false)
}