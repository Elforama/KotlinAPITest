package com.example.lawrencemuller.kotlinapitest.dagger.components

import com.example.lawrencemuller.kotlinapitest.dagger.modules.ApplicationModule
import com.example.lawrencemuller.kotlinapitest.mvp.MainActivityKotlin
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/14/16.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(activity: MainActivityKotlin)
}