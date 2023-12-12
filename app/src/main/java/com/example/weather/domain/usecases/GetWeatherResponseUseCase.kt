package com.example.weather.domain.usecases


import com.example.weather.domain.entity.WeatherResponseEntity
import com.example.weather.domain.repository.WeatherResponseRepository
import javax.inject.Inject

class GetWeatherResponseUseCase @Inject constructor(
    private val repository: WeatherResponseRepository
) {
    suspend fun execute(lat: Double, lon: Double): WeatherResponseEntity =
        repository.getWeatherResponse(lat, lon)

}