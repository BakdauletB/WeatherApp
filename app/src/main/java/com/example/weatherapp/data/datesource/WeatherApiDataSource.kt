package com.example.weatherapp.data.datesource

import com.cjmobileapps.weatherandroid2023.util.coroutine.CoroutineDispatchers
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.LocationCoordinate
import com.example.weatherapp.data.network.WeatherApi
import kotlinx.coroutines.withContext
import retrofit2.Response

class WeatherApiDataSource(
    private val weatherApi: WeatherApi,
    private val coroutineDispatchers: CoroutineDispatchers
) {

    suspend fun getCoordinatesByLocationName(locationName: String): Response<List<LocationCoordinate>> {
        return withContext(coroutineDispatchers.io) {
            weatherApi
                .getCoordinatesByLocationNameAsync(locationName = locationName)
                .await()
        }
    }

    suspend fun getCurrentWeatherData(lat: Double, lon: Double): Response<CurrentWeather> {
        return withContext(coroutineDispatchers.io) {
            weatherApi
                .getCurrentWeatherDataAsync(
                    lat = lat,
                    lon = lon
                )
                .await()
        }
    }

    suspend fun reverseGeocoding(lat: Double, lon: Double): Response<List<LocationCoordinate>> {
        return withContext(coroutineDispatchers.io) {
            weatherApi
                .reverseGeocodingAsync(
                    lat = lat,
                    lon = lon
                )
                .await()
        }
    }
}