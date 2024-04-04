package com.example.weatherapp.data.datesource

import com.cjmobileapps.weatherandroid2023.util.coroutine.CoroutineDispatchers
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.LocationCoordinate
import com.example.weatherapp.data.room.WeatherDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class WeatherLocalDataSource(
    private val weatherDao: WeatherDao,
    private val coroutineDispatchers: CoroutineDispatchers
) {

    suspend fun getLocationCoordinateFlow(): Flow<LocationCoordinate?> {
        return withContext(coroutineDispatchers.io) {
            weatherDao.getLocationCoordinate()
        }
    }

    suspend fun createLocationCoordinate(locationCoordinates: LocationCoordinate) {
        withContext(coroutineDispatchers.io) {
            weatherDao.deleteAllLocationCoordinate()
            weatherDao.insertLocationCoordinate(locationCoordinates)
        }
    }

    suspend fun createCurrentWeather(currentWeather: CurrentWeather) {
        withContext(coroutineDispatchers.io) {
            weatherDao.deleteCurrentWeather()
            weatherDao.insertCurrentWeather(currentWeather)
        }
    }

    suspend fun getCurrentWeatherFlow(): Flow<CurrentWeather?> {
        return withContext(coroutineDispatchers.io) {
            weatherDao.getCurrentWeather()
        }
    }
}