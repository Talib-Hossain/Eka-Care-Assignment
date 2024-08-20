package com.example.ekacareassignment.db

import androidx.room.Dao
import androidx.room.Insert
import com.example.ekacareassignment.data.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)
}