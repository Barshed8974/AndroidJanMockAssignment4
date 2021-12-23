package com.assignment.androidjanmockassignment_iv.View

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.androidjanmockassignment_iv.ModelClasses.MyModel
import com.assignment.androidjanmockassignment_iv.R
import com.assignment.androidjanmockassignment_iv.REPOSITORY.Myrepository
import com.assignment.androidjanmockassignment_iv.ViewModel.MyContentProvider
import com.assignment.androidjanmockassignment_iv.ViewModel.MyViewModel
import com.assignment.androidjanmockassignment_iv.ViewModel.MyViewModelFactory
import com.example.mvm_i.data.local.phoneBook
import com.example.mvm_i.data.local.phoneBookRoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),ItemOnclick {
    val PERMISSION = 100
    lateinit var list: ArrayList<MyModel>
    var list2= mutableListOf<MyModel>()
    lateinit var viewModel: MyViewModel
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isPermissionGranted = ActivityCompat.checkSelfPermission(this,
            Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED

        if (isPermissionGranted) {
            var fetch = MyContentProvider(this)
            viewModel = ViewModelProviders.of(
                this, MyViewModelFactory(
                    Myrepository(phoneBookRoomDatabase.getDatabaseObject(this).getTaskDAO())
                )
            ).get(MyViewModel::class.java)

            list = fetch.fetchall()
            CoroutineScope(Dispatchers.IO).launch {
                list.forEach {
                    viewModel.createTask(phoneBook(it.number, it.name, it.rank))
                }
            }
            viewModel.getAllTask().observe(this, {
                it.forEach {
                    list2.add(MyModel(it.name, it.number, it.Rank))
                }
                myAdapter= MyAdapter(this,list2,this)
                recycler.adapter=myAdapter
                recycler.layoutManager=LinearLayoutManager(this)
            })
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSION
            )
        }

    }

    override fun onClick(myModel: MyModel) {
        Log.d("All iss well",myModel.name+" "+myModel.rank)
        var x=myModel.rank
        x=x+1
        viewModel.editTask(phoneBook(myModel.name,myModel.number,x))
        list2.clear()
        viewModel.getAllTask().observe(this,{
            it.forEach {
                list2.add(MyModel(it.name, it.number, it.Rank))
            }
            myAdapter.notifyDataSetChanged()
        })
    }
}