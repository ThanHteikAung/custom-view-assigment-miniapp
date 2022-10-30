package com.padc.customviewassigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import com.padc.customviewassigment.views.viewholders.CreateNewTaskViewHolder

class CreateNewTaskAdapter : RecyclerView.Adapter<CreateNewTaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateNewTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_profile_image,parent,false)
        return CreateNewTaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: CreateNewTaskViewHolder, position: Int) {
        //last View Holder change image
        when(position){
            2 ->{
                holder.lastViewHolderChangeToAddButton()
            }
        }
    }
}