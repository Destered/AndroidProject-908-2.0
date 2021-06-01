package com.dester.androidproject_908_20.presenter.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    var username: String,
    var password: String,
    var aboutMe: String? = "",

) : Parcelable
