package com.dester.androidproject_908_20.data.api

import retrofit2.Retrofit

interface BaseService

internal inline fun <reified T : BaseService> Retrofit.make(): T =
    create(T::class.java)