package com.example.weather.domain.entity.forecasts.parts.dayshort

interface DayShortEntity{
    val temp: Int
    val temp_min: Int
    val condition: String
    val feels_like: Int
    val humidity: Int
    val wind_speed: Double
}