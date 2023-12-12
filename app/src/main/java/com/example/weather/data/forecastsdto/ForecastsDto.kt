package com.example.weather.data.forecastsdto

import com.example.weather.data.forecastsdto.parts.PartsDto
import com.example.weather.domain.entity.forecasts.ForecastsEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastsDto(
    @Json(name = "date")
    override val date: String,
    @Json(name = "sunset")
    override val sunset: String,
    @Json(name = "parts")
    override val parts: PartsDto,
    @Json(name = "hours")
    override val hours: List<HoursDto>,
) : ForecastsEntity