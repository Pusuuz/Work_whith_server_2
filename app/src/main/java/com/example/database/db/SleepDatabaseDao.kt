package com.example.database.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
 interface SleepDatabaseDao{

    @Insert
    suspend fun insert(night: SleepNight)

    @Update
    suspend fun update(night: SleepNight)

    @Query("SELECT * FROM daily_sleep ORDER BY userId DESC LIMIT 1;")
    suspend fun get(): SleepNight?


    @Query("DELETE FROM daily_sleep")
    suspend fun clear()
 }
