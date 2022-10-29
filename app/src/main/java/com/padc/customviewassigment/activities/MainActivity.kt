package com.padc.customviewassigment.activities

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.padc.customviewassigment.R
import com.padc.customviewassigment.adapters.ProfileAdapter
import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate
import com.padc.customviewassigment.mvp.presenters.MainPresenter
import com.padc.customviewassigment.mvp.presenters.MainPresenterImpl
import com.padc.customviewassigment.mvp.views.MainView
import com.padc.customviewassigment.views.viewpods.ProgressCardViewpod
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_detail_list.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var mProfileAdapter: ProfileAdapter
    lateinit var mMyItemDecoration: MyItemDecoration
    lateinit var mProgressCardViewpod: ProgressCardViewpod
    lateinit var mProfileDetailProgressCardViewPod: ProgressCardViewpod

    //Presenter
    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpRecyclerProfileList()
        setUpProgressViewPodList()
        setUpListener()
        setUpTabLayout()


    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.initView(this)
    }


    //setup Profile Image circle list
    private fun setUpRecyclerProfileList() {
        mProfileAdapter = ProfileAdapter()
        mMyItemDecoration = MyItemDecoration()
        rvProfileList.addItemDecoration(mMyItemDecoration) //Overlap Profile Image
        rvProfileList.adapter = mProfileAdapter
        rvProfileList.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

    }

    //set up viewPod for all screen
    private fun setUpProgressViewPodList() {
        //setup viewPod for Main Screen
        mProgressCardViewpod = vpProgressCard as ProgressCardViewpod
        mProgressCardViewpod.setProgressCardViewPod(mPresenter)

        //setup viewPod for Profile Detail Screen
        mProfileDetailProgressCardViewPod = vpProgressDetailCard as ProgressCardViewpod
        mProfileDetailProgressCardViewPod.setProgressCardViewPod(mPresenter)
    }

    //close ProfileDetail Screen
    private fun setUpListener(){
        btnClose.setOnClickListener {
            mPresenter.onTapProfileItem()
        }
    }

    //set up BottomSheet for Profile Detail Screen(ProfileDetailListActivity.kt)
    override fun showBottomSheet() {
        val sheet = BottomSheetBehavior.from(bottomSheet)
        when {
            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> {
                sheet.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

    }

    //Tab Layout set up Name
    private fun setUpTabLayout() {
        val tabDataList = listOf("Project Tasks", "Contacts", "About you")
        tabDataList.forEach {
            tabProfileDetail.newTab().apply {
                text = it
                println("Test@ $text")
                tabProfileDetail.addTab(this)
            }
        }
    }

    override fun showError(strError: String) {

    }

}

//Overlap RecyclerView item
class MyItemDecoration : RecyclerView.ItemDecoration() {

    private val overlapValue = -80

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0, 0, overlapValue, 0)  // args is : left,top,right,bottom
    }
}