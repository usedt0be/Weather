package com.example.weather.data.forecastsdto.parts.dayshortdto

import com.example.weather.domain.entity.forecasts.parts.dayshort.DayShortEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DayShortDto(
    @Json(name = "temp")
    override val temp: Int,
    @Json(name = "temp_min")
    override val temp_min: Int,
    @Json(name = "condition")
    override val condition: String,
    @Json(name = "feels_like")
    override val feels_like: Int,
    @Json(name = "humidity")
    override val humidity: Int,
    @Json(name = "wind_speed")
    override val wind_speed: Double,
) : DayShortEntity