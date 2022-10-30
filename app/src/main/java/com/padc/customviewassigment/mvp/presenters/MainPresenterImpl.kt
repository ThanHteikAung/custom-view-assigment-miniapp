package com.padc.customviewassigment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.customviewassigment.mvp.views.MainView

class MainPresenterImpl : ViewModel(),MainPresenter {

    var mView: MainView? = null

    override fun initView(view: MainView) {
        mView = view
    }

    //set up BottomSheet for Profile Detail Screen(ProfileDetailListActivity.kt)
    override fun onTapProfileItem() {
        mView?.showBottomSheet()
    }

    override fun onTapPlus() {
        mView?.navigateToCreateNewTask()
    }


}