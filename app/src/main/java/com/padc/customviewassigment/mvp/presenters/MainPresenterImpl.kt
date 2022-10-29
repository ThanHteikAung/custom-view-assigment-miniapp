package com.padc.customviewassigment.mvp.presenters

import com.padc.customviewassigment.mvp.views.MainView

class MainPresenterImpl : MainPresenter {

    var mView : MainView? = null

    override fun initView(view: MainView) {
        mView = view
    }
}