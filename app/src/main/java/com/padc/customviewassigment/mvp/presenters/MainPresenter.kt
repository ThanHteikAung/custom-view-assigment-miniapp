package com.padc.customviewassigment.mvp.presenters

import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate
import com.padc.customviewassigment.mvp.views.MainView

interface MainPresenter : ProgressViewHolderDelegate {
    fun initView(view: MainView)
}