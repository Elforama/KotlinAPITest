package com.example.lawrencemuller.kotlinapitest.net

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Jonathan Muller on 8/31/16.
 */
interface GithubService {

    @GET("users/{username}/repos")
    fun getUser(@Path("username") username: String): Observable<Array<Repo>>
}