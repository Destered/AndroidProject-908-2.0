package com.dester.androidproject_908_20.data.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryRequest(
    //common
    var requestType : String,
    var name: String? = null,
    var id: Int? = null,
    var type: String? = null,
    var page: Int? = null,
    //character
    var status: String? = null,
    var species: String? = null,
    var gender: String? = null,
    //location
    var dimension: String? = null,
    //episodes
    var episode: String? = null

) : Parcelable