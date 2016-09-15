package com.example.lawrencemuller.kotlinapitest.dagger.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Jonathan Muller on 9/14/16.
 */
@Module
class RetrofitModule(val baseUrl: String) {

    @Provides
    @Singleton
    fun providesGson() : Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }
}