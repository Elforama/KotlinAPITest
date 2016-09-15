package com.example.lawrencemuller.kotlinapitest.mvp

/**
 * Created by Jonathan Muller on 9/14/16.
 */
interface MainScreenMvp {

    interface View {
        fun onDataLoaded(data: String?)
        fun onError(error: String?)
    }

    interface Presenter {
        fun getData()
        fun bindView(view: MainScreenMvp.View?)
    }
}