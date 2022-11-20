package com.example.database.db

import android.content.Context
import androidx.room.Room

object DBobject {
    @Volatile
    private var INSTANCE: SleepDatabase? = null

    fun getInstance(context: Context): SleepDatabase {

        synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    SleepDatabase::class.java,
                    "sleep_history_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}