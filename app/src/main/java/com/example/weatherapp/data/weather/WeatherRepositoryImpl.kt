package com.example.weatherapp.data.weather


import com.example.weatherapp.data.datesource.WeatherApiDataSource
import com.example.weatherapp.data.datesource.WeatherLocalDataSource
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.LocationCoordinate
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl(
    private val weatherApiDataSource: WeatherApiDataSource,
    private val weatherLocalDataSource: WeatherLocalDataSource
) : WeatherRepository {

    override suspend fun getCoordinatesByLocationName(locationName: String) =
        weatherApiDataSource.getCoordinatesByLocationName(locationName = locationName)

    override suspend fun getLocationCoordinateFlow() =
        weatherLocalDataSource.getLocationCoordinateFlow()

    override suspend fun createLocationCoordinate(locationCoordinates: LocationCoordinate) =
        weatherLocalDataSource.createLocationCoordinate(locationCoordinates)

    override suspend fun getCurrentWeatherData(lat: Double, lon: Double) =
        weatherApiDataSource.getCurrentWeatherData(
            lat = lat,
            lon = lon
        )

    override suspend fun reverseGeocoding(
        lat: Double,
        lon: Double
    ) = weatherApiDataSource.reverseGeocoding(
        lat = lat,
        lon = lon
    )

    override suspend fun createCurrentWeather(currentWeather: CurrentWeather) =
        weatherLocalDataSource.createCurrentWeather(currentWeather = currentWeather)

    override suspend fun getCurrentWeatherFlow(): Flow<CurrentWeather?> = weatherLocalDataSource.getCurrentWeatherFlow()
}
