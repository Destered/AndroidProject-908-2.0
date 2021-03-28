package com.dester.androidproject_908_20.data.api


import com.dester.androidproject_908_20.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {


    private val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        original.url().newBuilder()
            .build()
            .let {
                chain.proceed(
                    original.newBuilder().url(it).build()
                )
            }
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val universityApi: UniversityApi by lazy {
        retrofit.create(UniversityApi::class.java)
    }
}