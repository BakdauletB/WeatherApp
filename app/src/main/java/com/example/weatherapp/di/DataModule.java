package com.example.weatherapp.di;

import android.content.Context;


import com.cjmobileapps.weatherandroid2023.util.coroutine.CoroutineDispatchers;
import com.example.weatherapp.data.datesource.WeatherApiDataSource;
import com.example.weatherapp.data.datesource.WeatherLocalDataSource;
import com.example.weatherapp.data.network.WeatherApi;
import com.example.weatherapp.data.room.DatabaseFactory;
import com.example.weatherapp.data.room.WeatherDao;
import com.example.weatherapp.data.room.WeatherDatabase;
import com.example.weatherapp.data.weather.WeatherRepository;
import com.example.weatherapp.data.weather.WeatherRepositoryImpl;
import com.example.weatherapp.data.weather.WeatherUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DataModule {

    @Singleton
    @Provides
    WeatherApiDataSource weatherApiDataSource(
            WeatherApi weatherApi,
            CoroutineDispatchers coroutineDispatchers
    ) {
        return new WeatherApiDataSource(
                weatherApi,
                coroutineDispatchers
        );
    }

    @Singleton
    @Provides
    WeatherRepository weatherRepository(
            WeatherApiDataSource weatherApiDataSource,
            WeatherLocalDataSource weatherLocalDataSource
    ) {
        return new WeatherRepositoryImpl(
                weatherApiDataSource,
                weatherLocalDataSource
        );
    }

    @Singleton
    @Provides
    WeatherUseCase weatherUseCase(
            WeatherRepository weatherRepository
    ) {
        return new WeatherUseCase(
                weatherRepository
        );
    }


    @Singleton
    @Provides
    WeatherDatabase weatherDatabase(
            @ApplicationContext Context context
    ) {
        return DatabaseFactory.Companion.getWeatherDatabase(context);
    }


    @Singleton
    @Provides
    WeatherDao weatherDao(
            WeatherDatabase weatherDatabase
    ) {
        return weatherDatabase.weatherDao();
    }


    @Singleton
    @Provides
    WeatherLocalDataSource weatherLocalDataSource(
            WeatherDao weatherDao,
            CoroutineDispatchers coroutineDispatchers
    ) {
        return new WeatherLocalDataSource(
                weatherDao,
                coroutineDispatchers
        );
    }
}
