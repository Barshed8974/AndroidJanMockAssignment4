package com.assignment.androidjanmockassignment_iv.View

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.androidjanmockassignment_iv.ModelClasses.MyModel
import com.assignment.androidjanmockassignment_iv.R
import kotlinx.android.synthetic.main.item1.view.*

class MyAdapter(var context: Context, var list: List<MyModel>, var itemOnclick: ItemOnclick): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item1,parent,false)
        return MyViewHolder(view,itemOnclick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sms=list.get(position)
        holder.setData(sms)
        Log.d("Allout",sms.rank.toString())
    }

    override fun getItemCount(): Int {
        return list.size
    }
}