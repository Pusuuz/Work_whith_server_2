package com.example.database.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
 interface SleepDatabaseDao{

    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    @Query("SELECT * from daily_sleep WHERE userId = :key")
    fun get(key: Long): SleepNight?


    @Query("DELETE FROM daily_sleep")
    fun clear()
 }
