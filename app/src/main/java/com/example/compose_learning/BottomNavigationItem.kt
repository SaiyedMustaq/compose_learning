package com.example.compose_learning

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(var label:String="",var icon: ImageVector= Icons.Default.Home,var route:String=""){

    fun bottomNavigationItem():List<BottomNavigationItem>{
            return  listOf(
                BottomNavigationItem(
                    "Home",
                    Icons.Default.Home,
                    AppRouts.HOME
                ),
                BottomNavigationItem(
                    "Notification",
                    Icons.Default.Notifications,
                    AppRouts.NOTIFICATION
                ),
                BottomNavigationItem(
                    "Profile",
                    Icons.Default.Person,
                    AppRouts.PROFILE
                ),
            )
    }
}
