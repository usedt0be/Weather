package com.example.weather.presentation.di

import com.example.weather.data.repository.WeatherResponseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

class AppModule {
    @Singleton
    @Provides
    fun provideWeatherResponseRepositoryImpl(): WeatherResponseRepositoryImpl {
        return WeatherResponseRepositoryImpl()
    }

}
