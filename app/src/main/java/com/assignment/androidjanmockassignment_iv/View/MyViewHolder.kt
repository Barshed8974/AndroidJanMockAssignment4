package com.assignment.androidjanmockassignment_iv.View

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.assignment.androidjanmockassignment_iv.ModelClasses.MyModel
import kotlinx.android.synthetic.main.item1.view.*

class MyViewHolder(itemVIew: View,var itemOnclick: ItemOnclick) : RecyclerView.ViewHolder(itemVIew) {
    fun setData(mess: MyModel)
    {
        itemView.tvName.text=mess.name
        itemView.tvNumber.text=mess.number
        itemView.tvRank.text=mess.rank.toString()
        itemView.setOnClickListener(View.OnClickListener {
            itemOnclick.onClick(mess)
        })
    }

}