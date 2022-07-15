package com.example.funicaapp

import androidx.annotation.DrawableRes

data class MenuItem(
    @DrawableRes
    val icon: Int,
    val title: String,
    @DrawableRes
    val enterIcon: Int?,
    val description: String? = null,
    val hasSwitch: Boolean = false,
)