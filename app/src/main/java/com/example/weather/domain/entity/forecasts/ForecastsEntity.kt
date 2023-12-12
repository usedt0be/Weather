package com.example.weather.domain.entity.forecasts

import com.example.weather.domain.entity.forecasts.parts.PartsEntity

interface ForecastsEntity {
    val date: String?
    val sunset: String
    val hours: List<HoursEntity?>
    val parts: PartsEntity
}