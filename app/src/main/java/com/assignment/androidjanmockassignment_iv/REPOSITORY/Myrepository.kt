package com.assignment.androidjanmockassignment_iv.REPOSITORY

import androidx.lifecycle.LiveData
import com.example.mvm_i.data.local.phoneBook
import com.example.mvm_i.data.local.phoneBookDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Myrepository(private val phoneBookDAO: phoneBookDAO) {
    fun addTask(phoneBook: phoneBook) {
        CoroutineScope(Dispatchers.IO).launch {
            phoneBookDAO.addTask(phoneBook) }
    }

    fun getAllTasksFromTable() : LiveData<List<phoneBook>> {
        return phoneBookDAO.getTasks()
    }
    fun editTask(phoneBook: phoneBook) {
        CoroutineScope(Dispatchers.IO).launch {
            phoneBookDAO.updateTask(phoneBook) }
    }
    fun deleteTask(phoneBook: phoneBook) {
        CoroutineScope(Dispatchers.IO).launch {
            phoneBookDAO.delete(phoneBook) }
    }
}