package com.example.lawrencemuller.kotlinapitest.dagger.components

import com.example.lawrencemuller.kotlinapitest.dagger.modules.GithubModule
import com.example.lawrencemuller.kotlinapitest.dagger.modules.RetrofitModule
import com.example.lawrencemuller.kotlinapitest.mvp.MainScreenPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/14/16.
 */
@Singleton
@Component(modules = arrayOf(GithubModule::class, RetrofitModule::class))
interface NetworkComponent {
    fun inject(presenter: MainScreenPresenter)
}