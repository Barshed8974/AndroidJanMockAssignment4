package com.assignment.androidjanmockassignment_iv.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assignment.androidjanmockassignment_iv.REPOSITORY.Myrepository
import com.example.mvm_i.data.local.phoneBook


class MyViewModel(val repository: Myrepository) : ViewModel() {



    fun createTask(phoneBook: phoneBook)
    {
        repository.addTask(phoneBook)
    }
    fun getAllTask(): LiveData<List<phoneBook>>
    {
        return repository.getAllTasksFromTable()
    }
    fun editTask(phoneBook: phoneBook)
    {
        repository.editTask(phoneBook)
    }

    fun deleteTask(phoneBook: phoneBook)
    {
        repository.deleteTask(phoneBook)
    }
}