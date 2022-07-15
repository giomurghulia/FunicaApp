package com.example.funicaapp

import androidx.annotation.DrawableRes

sealed class SettingListItem(val Id: ViewType) {
    enum class ViewType {
        PROFILE,
        MENUITEM
    }

    data class Profile(
        @DrawableRes val profileImg: Int,
        val fullName: String,
        val mobileNumber: String
    ) : SettingListItem(ViewType.PROFILE)

    data class MenuItem(
        @DrawableRes val icon: Int,
        val title: String,
        @DrawableRes val enterIcon: Int?,
        val description: String? = null,
        val hasSwitch: Boolean = false,
    ) : SettingListItem(ViewType.MENUITEM)


}