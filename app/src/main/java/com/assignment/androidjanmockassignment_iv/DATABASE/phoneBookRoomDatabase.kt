package com.example.mvm_i.data.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [phoneBook::class], version = 2)
abstract class phoneBookRoomDatabase : RoomDatabase() {

    abstract fun getTaskDAO(): phoneBookDAO

    companion object {

        private var INSTANCE: phoneBookRoomDatabase? = null

        fun getDatabaseObject(context: Context): phoneBookRoomDatabase {

            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    phoneBookRoomDatabase::class.java,
                    "task_db"
                )

                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }

    }

}