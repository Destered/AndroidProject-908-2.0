package com.dester.androidproject_908_20.data.api.response

data class BaseCategoryData(
    val name: String,
    val type: String,
    val id: Int,
)

fun convertToBaseData(data:CharacterResult):BaseCategoryData{
    return BaseCategoryData(
        data.name,
        "character",
        data.id
    )
}

fun convertToBaseData(data:LocationResult):BaseCategoryData{
    return BaseCategoryData(
        data.name,
        "character",
        data.id
    )
}

fun convertToBaseData(data:EpisodeResult):BaseCategoryData{
    return BaseCategoryData(
        data.name,
        "character",
        data.id
    )
}

