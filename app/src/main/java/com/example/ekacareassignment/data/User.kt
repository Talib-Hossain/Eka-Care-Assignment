package com.example.ekacareassignment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val fullName: String,
    val age: String,
    val address: String,
    val dob: String
)
