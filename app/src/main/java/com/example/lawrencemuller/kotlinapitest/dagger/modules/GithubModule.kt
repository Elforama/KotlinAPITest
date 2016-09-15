package com.example.lawrencemuller.kotlinapitest.dagger.modules

import com.example.lawrencemuller.kotlinapitest.net.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/14/16.
 */
@Module
class GithubModule {

    @Provides
    @Singleton
    fun provideGithubService (retrofit: Retrofit) : GithubService {
        return retrofit.create(GithubService::class.java)
    }
}