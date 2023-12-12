package com.example.weather.domain.entity.forecasts.parts.night

interface NightShortEntity {
    val temp_min: Int
    val condition: String
    val humidity : Int
}