package com.padc.customviewassigment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import com.padc.customviewassigment.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.viewholder_profile_image.view.*

class ProfileViewHolder(itemView: View,private val mDelegate: ProfileDelegate) : RecyclerView.ViewHolder(itemView)  {
    init {
        itemView.ivProfile.setOnClickListener {
            mDelegate.onTapPlus()
        }
    }

    fun lastViewHolderChangeToAddButton(){
        itemView.ivProfile.setImageResource(R.drawable.plus_icon)
    }
}