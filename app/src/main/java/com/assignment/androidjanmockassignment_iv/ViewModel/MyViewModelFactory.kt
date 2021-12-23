package com.assignment.androidjanmockassignment_iv.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.androidjanmockassignment_iv.REPOSITORY.Myrepository

class MyViewModelFactory (private  val repo: Myrepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("ALI","Factory")
        return MyViewModel(repo) as T
    }
}