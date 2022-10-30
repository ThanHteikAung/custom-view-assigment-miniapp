package com.padc.customviewassigment.activities

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.customviewassigment.R
import com.padc.customviewassigment.adapters.CreateNewTaskAdapter
import kotlinx.android.synthetic.main.activity_create_new_task.*
import kotlinx.android.synthetic.main.activity_main.btnBack

class CreateNewTaskActivity : AppCompatActivity() {

    lateinit var mCreateTaskAdapter: CreateNewTaskAdapter
    lateinit var mCreateDecoration: CreateTaskDecoration

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,CreateNewTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_task)
        setUpListener()
        setUpRecyclerProfileList()
    }

    private fun setUpListener(){
        btnBack.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }
    }

    //setup Profile Image circle list
    private fun setUpRecyclerProfileList() {
        mCreateTaskAdapter = CreateNewTaskAdapter()
        mCreateDecoration = CreateTaskDecoration()
        rvAssignList.addItemDecoration(mCreateDecoration) //Overlap Profile Image
        rvAssignList.adapter = mCreateTaskAdapter
        rvAssignList.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
    }
}

//Overlap RecyclerView item
class CreateTaskDecoration : RecyclerView.ItemDecoration() {

    private val overlapValue = -120

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0, 0, overlapValue, 0)  // args is : left,top,right,bottom
    }
}
