package com.jagruti.myapplication.model

data class User(
    val email: String,
    val gender: String,
    val location: Location,
    val login: Login,
    val name: Name,
    val phone: String,
    val picture: Picture
)