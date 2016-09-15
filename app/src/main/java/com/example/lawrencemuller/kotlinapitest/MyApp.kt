package com.example.lawrencemuller.kotlinapitest

import android.app.Application
import com.example.lawrencemuller.kotlinapitest.dagger.components.ApplicationComponent
import com.example.lawrencemuller.kotlinapitest.dagger.components.DaggerApplicationComponent
import com.example.lawrencemuller.kotlinapitest.dagger.components.DaggerNetworkComponent
import com.example.lawrencemuller.kotlinapitest.dagger.components.NetworkComponent
import com.example.lawrencemuller.kotlinapitest.dagger.modules.ApplicationModule
import com.example.lawrencemuller.kotlinapitest.dagger.modules.GithubModule
import com.example.lawrencemuller.kotlinapitest.dagger.modules.RetrofitModule
import com.example.lawrencemuller.kotlinapitest.net.Constants

/**
 * Created by Jonathan Muller on 9/14/16.
 */
class MyApp : Application() {

    var app : MyApp = this

    companion object {
        @JvmStatic lateinit var instance: Application
        @JvmStatic lateinit var mNetworkComponent: NetworkComponent
        @JvmStatic lateinit var mAppComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        mAppComponent = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()

        mNetworkComponent = DaggerNetworkComponent.builder()
        .githubModule(GithubModule())
        .retrofitModule(RetrofitModule(Constants.ENDPOINT_BASE))
        .build()
    }
}