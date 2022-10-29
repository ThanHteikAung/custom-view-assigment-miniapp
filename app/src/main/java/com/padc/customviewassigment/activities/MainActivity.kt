package com.padc.customviewassigment.activities

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import com.padc.customviewassigment.adapters.ProfileAdapter
import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate
import com.padc.customviewassigment.mvp.views.MainView
import com.padc.customviewassigment.views.viewpods.ProgressCardViewpod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ProgressViewHolderDelegate {

    lateinit var mProfileAdapter: ProfileAdapter
    lateinit var mMyItemDecoration: MyItemDecoration
    lateinit var mProgressCardViewpod: ProgressCardViewpod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerProfileList()
        setUpProgressViewPodList()

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

    private fun setUpProgressViewPodList(){
        mProgressCardViewpod = vpProgressCard as ProgressCardViewpod
        mProgressCardViewpod.setProgressCardViewPod(this)
    }

    override fun onTapProfileItem() {

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