package com.example.lawrencemuller.kotlinapitest.dagger.modules

import com.example.lawrencemuller.kotlinapitest.net.GithubProvider
import com.example.lawrencemuller.kotlinapitest.net.GithubService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/15/16.
 */
@Module
class BackendModule {

    @Provides
    @Singleton
    fun provideGithubProvider (service: GithubService) : GithubProvider {
        return GithubProvider()
    }

}