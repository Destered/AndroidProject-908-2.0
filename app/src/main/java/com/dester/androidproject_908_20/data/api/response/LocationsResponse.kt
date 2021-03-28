package com.dester.androidproject_908_20.data.api.response
import com.google.gson.annotations.SerializedName


data class LocationsResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<LocationResult>
)


data class LocationResult(
    @SerializedName("created")
    val created: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)