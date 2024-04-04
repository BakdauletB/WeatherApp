package com.example.weatherapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.presentation.screens.detail.WeatherDetailUi
import com.example.weatherapp.presentation.screens.detail.viewmodel.WeatherDetailViewModel
import com.example.weatherapp.presentation.screens.detail.viewmodel.WeatherDetailViewModelImpl
import com.example.weatherapp.presentation.screens.search.SearchUi
import com.example.weatherapp.presentation.screens.search.viewmodel.SearchViewModel
import com.example.weatherapp.presentation.screens.search.viewmodel.SearchViewModelImpl


@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startRoute: String,
){
    NavHost(navController = navController, startDestination = NavItem.WeatherDetail.nav_route) {
        composable(NavItem.WeatherDetail.nav_route) {
            val weatherDetailViewModel: WeatherDetailViewModel = hiltViewModel<WeatherDetailViewModelImpl>()

            WeatherDetailUi(
                navController = navController,
                weatherDetailViewModel = weatherDetailViewModel
            )
        }
        composable(NavItem.Search.nav_route) {
            val searchViewModel: SearchViewModel = hiltViewModel<SearchViewModelImpl>()

            SearchUi(
                navController = navController,
                searchViewModel = searchViewModel
            )
        }
    }

}
