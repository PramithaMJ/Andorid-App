package com.example.studentregisterapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase(){
    abstract fun studentDao():StudentDao
    companion object{
        @Volatile // immediately visible to other thread
        private var INSTANCE : StudentDatabase? = null
        fun getInstance(context: Context):StudentDatabase{
            synchronized(this){ // thread safety and locking technique
                var instance = INSTANCE
                if (instance == null){ // check database is create or not
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "student_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}