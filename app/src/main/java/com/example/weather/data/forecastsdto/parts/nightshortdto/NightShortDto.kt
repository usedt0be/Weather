package com.example.weather.data.forecastsdto.parts.nightshortdto

import com.example.weather.domain.entity.forecasts.parts.night.NightShortEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NightShortDto(
    @Json(name = "temp")
    override val temp_min: Int,
//    @Json(name = "icon")
//    override val icon: String,
    @Json(name = "condition")
    override val condition: String,
    @Json(name = "humidity")
    override val humidity: Int

) : NightShortEntity


