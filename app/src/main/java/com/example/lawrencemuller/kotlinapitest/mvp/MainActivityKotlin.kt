package com.example.lawrencemuller.kotlinapitest.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lawrencemuller.kotlinapitest.KotlinExamples
import com.example.lawrencemuller.kotlinapitest.R
import com.example.lawrencemuller.kotlinapitest.views.ReversibleAnimatedVector

class MainActivityKotlin : AppCompatActivity() {

    val presenter: MainScreenMvp.Presenter = MainScreenPresenter()
    var view: MainScreenMvp.View? = null
    var image: ReversibleAnimatedVector? = null

    var isStop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity_kotlin)
        view = MainScreenView(findViewById(R.id.baseView), presenter)

        image = findViewById(R.id.imageView) as ReversibleAnimatedVector

        image?.setOnClickListener { handleClick() }



        KotlinExamples("Word")
    }
    fun handleClick() {
       image?.animateToNextState()
    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(view)
    }
}
