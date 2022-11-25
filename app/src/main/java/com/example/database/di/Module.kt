package com.example.database.di

import android.content.Context
import com.example.database.repository.UserRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    fun provideUserRepository(@ApplicationContext applicationContext: Context): UserRepository{

        return UserRepository(applicationContext)
    }


}