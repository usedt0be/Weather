package com.example.weather.domain.entity

import com.example.weather.domain.entity.fact.FactEntity
import com.example.weather.domain.entity.forecasts.ForecastsEntity
import com.example.weather.domain.entity.info.Info

interface WeatherResponseEntity{
    val info: Info
    val fact: FactEntity
    val forecasts: List<ForecastsEntity>
}
