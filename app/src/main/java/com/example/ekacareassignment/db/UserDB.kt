package com.example.ekacareassignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ekacareassignment.data.User

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {

    abstract fun userDao(): UserDao
}