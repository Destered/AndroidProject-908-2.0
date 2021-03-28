package com.dester.androidproject_908_20.data.api


import com.dester.androidproject_908_20.data.api.response.*
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UniversityApi: BaseService {

    @GET("character/")
     fun getCharacter(
        @Query("page")
        page: Int?,
        @Query("name")
        name: String?,
        @Query("status")
        status: String?,
        @Query("species")
        species: String?,
        @Query("type")
        type: String?,
        @Query("gender")
        gender: String?,

    ): Single<CharactersResponse>

    @GET("location/")
     fun getLocations(
        @Query("page")
        page: Int?,
        @Query("name")
        name: String?,
        @Query("type")
        type: String?,
        @Query("dimension")
        dimension: String?
    ): Single<LocationsResponse>

    @GET("episode/")
     fun getEpisodes(
        @Query("page")
        page: Int?,
        @Query("name")
        name: String?,
        @Query("episode")
        episode: String?
    ): Single<EpisodesResponse>

    @GET("character/{id}")
     fun getSingleCharacter(
        @Path("id")
        id: Int
    ): Single<CharacterResult>

    @GET("location/{id}")
     fun getSingleLocations(
        @Path("id")
        id: Int
    ): Single<LocationResult>

    @GET("episode/{id}")
     fun getSingleEpisodes(
        @Path("id")
        id: Int
    ): Single<EpisodeResult>
}



