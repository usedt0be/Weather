package com.example.weather.domain.entity.fact

interface FactEntity {
    val temp: Int
    val feels_like: Int
    val condition: String
    val wind_speed: Double
    val humidity: Int
    val cloudness: Double
    val pressure: Int
    val daytime: String
}
