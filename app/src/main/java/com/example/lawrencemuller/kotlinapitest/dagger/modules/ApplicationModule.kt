package com.example.lawrencemuller.kotlinapitest.dagger.modules

import android.app.Application
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/14/16.
 */
@Module
class ApplicationModule (app: Application){

    val mApp: Application

    init {
        mApp = app
    }

    @Provides
    @Singleton
    fun provideApplication() : Application {
        return mApp
    }

    @Provides
    @Singleton
    fun provideSharedPrefs() : SharedPreferences {
        return mApp.getSharedPreferences("TEST", 0)
    }
}