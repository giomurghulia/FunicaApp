package com.example.funicaapp

import androidx.annotation.DrawableRes

data class MenuItem(
    @DrawableRes
    val icon: Int,
    val title: String,
    val description: String?,
    @DrawableRes
    val enterIcon: Int?
)