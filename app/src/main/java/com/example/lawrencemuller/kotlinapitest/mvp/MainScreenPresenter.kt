package com.example.lawrencemuller.kotlinapitest.mvp

import android.util.Log
import com.example.lawrencemuller.kotlinapitest.MyApp
import com.example.lawrencemuller.kotlinapitest.net.GithubModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Jonathan Muller on 9/14/16.
 */
class MainScreenPresenter: MainScreenMvp.Presenter {

    var view: MainScreenMvp.View? = null

    @Inject
    lateinit var mGithubModel : GithubModel

    init {
        MyApp.mNetworkComponent.inject(this)
    }

    override fun bindView(view: MainScreenMvp.View?) {
        this.view = view
    }

    override fun getData() {
        mGithubModel.getRepo("elforama")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { view?.onDataLoaded(it?.toString()) },
                        { view?.onError(it.message) },
                        { Log.d("TAG", "Complete") }
                )
    }
}