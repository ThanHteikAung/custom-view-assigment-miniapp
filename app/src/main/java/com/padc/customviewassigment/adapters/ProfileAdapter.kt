package com.padc.customviewassigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import com.padc.customviewassigment.views.viewholders.ProfileViewHolder

class ProfileAdapter: RecyclerView.Adapter<ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_profile_image,parent,false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

        //last View Holder change image
        when(position){
            3 ->{
                holder.lastViewHolderChangeToAddButton()
            }
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}