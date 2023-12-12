package com.example.weather.data.repository

import com.example.weather.data.network.RetrofitInstance
import com.example.weather.data.response.WeatherResponseDto
import com.example.weather.domain.repository.WeatherResponseRepository
import javax.inject.Inject

class WeatherResponseRepositoryImpl @Inject constructor() : WeatherResponseRepository {
    override suspend fun getWeatherResponse(lat: Double, lon: Double): WeatherResponseDto {
        return RetrofitInstance.weatherApi.getWeather(lat = lat, lon = lon)
    }

}