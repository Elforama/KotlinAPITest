package com.example.lawrencemuller.kotlinapitest.mvp

import android.util.Log
import com.example.lawrencemuller.kotlinapitest.MyApp
import com.example.lawrencemuller.kotlinapitest.net.GithubService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Jonathan Muller on 9/14/16.
 */
class MainScreenPresenter: MainScreenMvp.Presenter {

    var view: MainScreenMvp.View? = null

    @Inject
    lateinit var mGithubService : GithubService

    init {
        MyApp.mNetworkComponent.inject(this)
    }

    override fun bindView(view: MainScreenMvp.View?) {
        this.view = view
    }

    override fun getData() {
        mGithubService.getUser("elforama")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { view?.onDataLoaded(it?.get(0)?.toString()) },
                        { view?.onError(it.message) },
                        { Log.d("TAG", "Complete") }
                )
    }
}