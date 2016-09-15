package com.example.lawrencemuller.kotlinapitest.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Jonathan Muller on 8/31/16.
 */
class GithubProvider {

    val githubService: GithubService

    init {
        githubService = Retrofit.Builder()
                .baseUrl(Constants.ENDPOINT_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(GithubService::class.java)
    }
}