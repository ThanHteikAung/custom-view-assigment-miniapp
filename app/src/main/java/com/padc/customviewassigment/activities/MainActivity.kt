package com.padc.customviewassigment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.customviewassigment.R
import com.padc.customviewassigment.adapters.ProfileAdapter
import com.padc.customviewassigment.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var mProfileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerProfileList()

    }


    //setup Profile Image circle list
    private fun setUpRecyclerProfileList(){
        mProfileAdapter = ProfileAdapter()
        rvProfileList.adapter = mProfileAdapter
        rvProfileList.layoutManager =LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)

    }

}