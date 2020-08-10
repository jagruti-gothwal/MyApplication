package com.jagruti.myapplication.userdb

import android.graphics.Picture
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jagruti.myapplication.model.Location

@Entity(tableName = "Users")
data class UserDetails(
    @PrimaryKey
    val phone: String,

    @ColumnInfo(name="name")
    val name: String?=null,

    @ColumnInfo(name="login")
    val login: String?=null,

    @ColumnInfo(name="gender")
    val gender: String?=null,

    @ColumnInfo(name="email")
    val email: String?=null,

    @ColumnInfo(name="picture")
    val picture: String?=null,

    @ColumnInfo(name="location")
    val location: String?=null

)