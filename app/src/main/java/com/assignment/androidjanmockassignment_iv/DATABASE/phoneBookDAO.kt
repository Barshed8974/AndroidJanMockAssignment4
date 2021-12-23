package com.example.mvm_i.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface phoneBookDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(phoneBook: phoneBook)

    @Query("select * from PhoneBook")
    fun getTasks(): LiveData<List<phoneBook>>

    @Update()
    fun updateTask(phoneBook: phoneBook)

    @Delete
    fun delete(phoneBook: phoneBook)

}