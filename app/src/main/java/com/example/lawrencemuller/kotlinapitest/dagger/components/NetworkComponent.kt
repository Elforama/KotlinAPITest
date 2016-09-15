package com.example.lawrencemuller.kotlinapitest.dagger.components

import com.example.lawrencemuller.kotlinapitest.dagger.modules.BackendModule
import com.example.lawrencemuller.kotlinapitest.dagger.modules.GithubModule
import com.example.lawrencemuller.kotlinapitest.dagger.modules.RetrofitModule
import com.example.lawrencemuller.kotlinapitest.mvp.MainScreenPresenter
import com.example.lawrencemuller.kotlinapitest.net.GithubProvider
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/14/16.
 */
@Singleton
@Component(modules = arrayOf(GithubModule::class, RetrofitModule::class, BackendModule::class))
interface NetworkComponent {
    fun inject(githubProvider: GithubProvider)
    fun inject(presenter: MainScreenPresenter)
}