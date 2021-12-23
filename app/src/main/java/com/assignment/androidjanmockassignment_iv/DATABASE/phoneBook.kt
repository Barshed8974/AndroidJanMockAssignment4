package com.example.mvm_i.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PhoneBook")
data class phoneBook(
    @PrimaryKey
    @ColumnInfo(name = "Name")
    var name: String,
    @ColumnInfo(name = "Number")
    var number: String,
    @ColumnInfo(name = "Rank")
    var Rank: Int

) {

}