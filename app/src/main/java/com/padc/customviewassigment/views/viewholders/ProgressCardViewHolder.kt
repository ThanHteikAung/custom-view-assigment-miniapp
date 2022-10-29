package com.padc.customviewassigment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.padc.customviewassigment.delegates.ProgressViewHolderDelegate
import kotlinx.android.synthetic.main.view_item_progress_card.view.*

class ProgressCardViewHolder(
    itemView: View,
    private val mProgressCardViewHolderDelegate: ProgressViewHolderDelegate
) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.ivProfileCard.setOnClickListener {
            mProgressCardViewHolderDelegate.onTapProfileItem()

        }
    }

}