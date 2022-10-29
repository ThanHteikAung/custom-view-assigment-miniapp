package com.padc.customviewassigment.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.customviewassigment.adapters.ProgressCardAdapter
import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate
import kotlinx.android.synthetic.main.viewpod_progress_card.view.*

class ProgressCardViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var mProgressCardAdapter: ProgressCardAdapter
    lateinit var mProgressViewHolderDelegate: ProgressViewHolderDelegate

    fun setProgressCardViewPod(delegate: ProgressViewHolderDelegate){
        setDelegate(delegate)
        setUpRecyclerProgressCardList()
    }
    
    private fun setDelegate(delegate : ProgressViewHolderDelegate){
        this.mProgressViewHolderDelegate = delegate
    }

    private fun setUpRecyclerProgressCardList(){
        mProgressCardAdapter = ProgressCardAdapter(mProgressViewHolderDelegate)
        rvProgressCardList.adapter = mProgressCardAdapter
        rvProgressCardList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

    }

}