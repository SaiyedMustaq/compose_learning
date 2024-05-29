package com.example.compose_learning

sealed class Screens (val rout:String){
    data object  Home:Screens(AppRouts.HOME)
    data object  Notification:Screens(AppRouts.NOTIFICATION)
    data object  Profile:Screens(AppRouts.PROFILE)
}