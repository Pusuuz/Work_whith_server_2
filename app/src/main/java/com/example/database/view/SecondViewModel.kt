package com.example.database.view

import androidx.lifecycle.ViewModel
import com.example.database.db.SleepNight
import com.example.database.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    suspend fun getUserData(): SleepNight?{
        return repository.getUser()
    }

}