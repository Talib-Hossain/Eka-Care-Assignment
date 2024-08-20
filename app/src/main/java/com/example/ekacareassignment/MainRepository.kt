package com.example.ekacareassignment

import com.example.ekacareassignment.data.User
import com.example.ekacareassignment.db.UserDB
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val db: UserDB
) {
    suspend fun insertUser(user: User){
        db.userDao().insertUser(user)
    }
}