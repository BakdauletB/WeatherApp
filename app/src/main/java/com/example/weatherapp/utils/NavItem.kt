package com.example.weatherapp.utils

sealed class NavItem(
    val nav_route: String
) {
    object Search : NavItem(nav_route = "nav_search")

    object WeatherDetail : NavItem(nav_route = "nav_weather_detail")
}