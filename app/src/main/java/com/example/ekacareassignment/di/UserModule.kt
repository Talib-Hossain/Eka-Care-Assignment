package com.example.ekacareassignment.di

import android.content.Context
import androidx.room.Room
import com.example.ekacareassignment.db.UserDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): UserDB {
        return Room.databaseBuilder(
            appContext,
            UserDB::class.java,
            "user_data"
        ).build()
    }
}