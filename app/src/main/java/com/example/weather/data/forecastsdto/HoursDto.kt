package com.example.weather.data.forecastsdto

import com.example.weather.domain.entity.forecasts.HoursEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HoursDto(
    @Json(name = "hour")
    override val hour: Int,
    @Json(name = "temp")
    override val temp: Int,
    @Json(name = "feels_like")
    override val feels_like: Int,
    @Json(name = "condition")
    override val condition: String
) : HoursEntity
