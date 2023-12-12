package com.example.weather.domain.repository

import com.example.weather.domain.entity.WeatherResponseEntity

interface WeatherResponseRepository {
    suspend fun getWeatherResponse(lat: Double, lon: Double): WeatherResponseEntity
}