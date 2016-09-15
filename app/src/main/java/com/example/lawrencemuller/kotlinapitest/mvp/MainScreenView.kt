package com.example.lawrencemuller.kotlinapitest.mvp

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lawrencemuller.kotlinapitest.R

/**
 * Created by Jonathan Muller on 9/14/16.
 */
class MainScreenView(val view: View, val presenter: MainScreenMvp.Presenter) : MainScreenMvp.View {

    val mTextView: TextView?
    val mButton: Button?

    init {
        mTextView = view.findViewById(R.id.textView) as TextView
        mButton = view.findViewById(R.id.button) as Button

        mButton.setOnClickListener { presenter.getData() }
    }

    override fun onDataLoaded(data: String?) {
        mTextView?.text = data
    }

    override fun onError(error: String?) {
        mTextView?.text = error
    }
}