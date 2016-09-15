package com.example.lawrencemuller.kotlinapitest.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lawrencemuller.kotlinapitest.R

class MainActivityKotlin : AppCompatActivity() {

    val presenter: MainScreenMvp.Presenter = MainScreenPresenter()
    var view: MainScreenMvp.View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_kotlin)
        view = MainScreenView(findViewById(R.id.baseView), presenter)
    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(view)
    }
}
