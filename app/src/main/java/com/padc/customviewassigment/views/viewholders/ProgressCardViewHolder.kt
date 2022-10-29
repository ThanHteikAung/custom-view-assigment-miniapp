package com.padc.customviewassigment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate

class ProgressCardViewHolder(
    itemView: View,
    private val mProgressCardViewHolderDelegate: ProgressViewHolderDelegate
) : RecyclerView.ViewHolder(itemView) {
}