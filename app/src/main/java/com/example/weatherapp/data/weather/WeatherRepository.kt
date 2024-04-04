package com.example.weatherapp.data.weather


import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.LocationCoordinate
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface WeatherRepository {

    suspend fun getCoordinatesByLocationName(locationName: String): Response<List<LocationCoordinate>>

    suspend fun getLocationCoordinateFlow(): Flow<LocationCoordinate?>

    suspend fun createLocationCoordinate(locationCoordinates: LocationCoordinate)

    suspend fun getCurrentWeatherData(lat: Double, lon: Double): Response<CurrentWeather>

    suspend fun reverseGeocoding(lat: Double, lon: Double): Response<List<LocationCoordinate>>

    suspend fun createCurrentWeather(currentWeather: CurrentWeather)

    suspend fun getCurrentWeatherFlow(): Flow<CurrentWeather?>
}
