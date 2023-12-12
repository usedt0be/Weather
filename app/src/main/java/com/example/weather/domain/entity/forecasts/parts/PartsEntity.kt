package com.example.weather.domain.entity.forecasts.parts

import com.example.weather.domain.entity.forecasts.parts.dayshort.DayShortEntity
import com.example.weather.domain.entity.forecasts.parts.night.NightShortEntity

interface PartsEntity {
    val day_short: DayShortEntity
    val night_short: NightShortEntity
}