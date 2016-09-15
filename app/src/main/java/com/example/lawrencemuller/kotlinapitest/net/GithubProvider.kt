package com.example.lawrencemuller.kotlinapitest.net

import com.example.lawrencemuller.kotlinapitest.MyApp
import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Jonathan Muller on 8/31/16.
 */
class GithubProvider {

    @Inject
    lateinit var mGithubService : GithubService

    init {
        MyApp.mNetworkComponent.inject(this)
    }

    fun getRepo(username: String) : Observable<Repo> {
        return mGithubService.getUser(username)
                .subscribeOn(Schedulers.io())
                .flatMap { Observable.from(it) }
                .first()
    }
}