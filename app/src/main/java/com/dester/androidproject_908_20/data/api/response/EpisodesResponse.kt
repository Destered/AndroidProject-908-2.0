package com.dester.androidproject_908_20.data.api.response
import com.google.gson.annotations.SerializedName


data class EpisodesResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<EpisodeResult>
)


data class EpisodeResult(
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)