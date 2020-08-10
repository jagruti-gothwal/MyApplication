package com.jagruti.myapplication.userdb

import androidx.room.Dao
import androidx.room.Query
import com.jagruti.myapplication.model.User

@Dao
interface UserDao{

    @Query("SELECT * from users")
    fun getAllUsers() : List<UserDetails>
}