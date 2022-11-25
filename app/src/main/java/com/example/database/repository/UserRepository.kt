package com.example.database.repository

import android.content.Context
import com.example.database.db.DBobject
import com.example.database.db.SleepNight

class UserRepository(context: Context) {

    private val db = DBobject.getInstance(context).sleepDatabaseDao

    fun insertToDB(data: SleepNight){
        db.update(data)
    }

    fun  getUser():SleepNight? {
    return db.get()
    }
}