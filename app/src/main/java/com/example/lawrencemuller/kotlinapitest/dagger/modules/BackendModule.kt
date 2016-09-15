package com.example.lawrencemuller.kotlinapitest.dagger.modules

import com.example.lawrencemuller.kotlinapitest.net.GithubModel
import com.example.lawrencemuller.kotlinapitest.net.GithubModelImpl
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
    fun provideGithubModel () : GithubModel {
        return GithubModelImpl()
    }

}