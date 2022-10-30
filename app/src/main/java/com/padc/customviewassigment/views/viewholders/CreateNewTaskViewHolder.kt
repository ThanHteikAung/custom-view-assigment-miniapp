package com.padc.customviewassigment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import kotlinx.android.synthetic.main.viewholder_profile_image.view.*

class CreateNewTaskViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    fun lastViewHolderChangeToAddButton(){
        itemView.ivProfile.setImageResource(R.drawable.plus_icon)
    }

}