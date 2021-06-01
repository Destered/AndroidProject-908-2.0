package com.dester.androidproject_908_20.presenter.main

import androidx.lifecycle.MutableLiveData
import com.dester.androidproject_908_20.presenter.base.BaseViewModel
import com.dester.androidproject_908_20.presenter.data.UserInfo

class MainVM(
    userData: UserInfo
): BaseViewModel() {
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    init {
        username.postValue(userData.username)
        password.postValue(userData.password)
    }
}