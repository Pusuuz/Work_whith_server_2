package com.example.database.db

import android.security.identity.AccessControlProfileId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_sleep")
data class SleepNight(

    @PrimaryKey(autoGenerate = true)
    var userId: Long,

    @ColumnInfo(name = "name")
    val userName: String ,

    var age: Int,

    var job: String
)
