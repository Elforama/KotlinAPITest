package com.example.lawrencemuller.kotlinapitest.net

import rx.Observable

/**
 * Created by Jonathan Muller on 9/15/16.
 */
interface GithubModel {

    fun getRepo(username: String) : Observable<Repo>
}