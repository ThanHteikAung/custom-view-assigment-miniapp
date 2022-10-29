package com.padc.customviewassigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate
import com.padc.customviewassigment.views.viewholders.ProgressCardViewHolder

class ProgressCardAdapter(val mProgressViewHolderDelegate: ProgressViewHolderDelegate ) : RecyclerView.Adapter<ProgressCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_progress_card,parent,false)
        return ProgressCardViewHolder(view,mProgressViewHolderDelegate)
    }

    override fun onBindViewHolder(holder: ProgressCardViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}