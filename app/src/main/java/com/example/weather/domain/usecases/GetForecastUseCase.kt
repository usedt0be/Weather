package com.example.weather.domain.usecases

import com.example.weather.data.repository.WeatherResponseRepositoryImpl
import com.example.weather.domain.entity.forecasts.ForecastsEntity
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: WeatherResponseRepositoryImpl
) {

    suspend fun execute(lat: Double, lon: Double): List<ForecastsEntity> {
        return repository.getWeatherResponse(lat = lat, lon = lon).forecasts
    }
}