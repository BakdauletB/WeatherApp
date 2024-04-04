package com.example.weatherapp.presentation.screens.search.viewmodel

import android.location.Location
import com.example.weatherapp.presentation.screens.search.viewmodel.SearchViewModelImpl.SearchState
import com.example.weatherapp.data.model.LocationCoordinate

interface SearchViewModel {
    fun getState(): SearchState

    fun currentLocationClicked(location: Location)

    fun locationClicked(locationCoordinate: LocationCoordinate)

    fun getSearchNavRouteUiNavRouteUiState(): SearchViewModelImpl.SearchNavRouteUi?

    fun goToWeatherDetailScreenUi()

    fun resetNavRouteUiToIdle()

    fun updateSearchEditText(text: String)

    fun getSearchEditText(): String

    fun getLocationCoordinates(): List<LocationCoordinate>
}
