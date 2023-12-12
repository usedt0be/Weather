package com.example.weather.data.forecastsdto.parts

import com.example.weather.data.forecastsdto.parts.dayshortdto.DayShortDto
import com.example.weather.data.forecastsdto.parts.nightshortdto.NightShortDto
import com.example.weather.domain.entity.forecasts.parts.PartsEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PartsDto(
    @Json(name = "day_short")
    override val day_short: DayShortDto,
    @Json(name = "night_short")
    override val night_short: NightShortDto
) : PartsEntity


