package com.example.tmdb.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Contact::class],version = 1)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun contactDao():MovieDAO
    companion object{
        private var INSTANCE : MovieDatabase?= null

        fun getDatabase(context: Context):MovieDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,MovieDatabase::class.java,"movieDB").build()
                }
            }
            return INSTANCE !!
        }
    }
}