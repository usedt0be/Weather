package com.example.weather.data.response

import com.example.weather.data.factdto.FactDto
import com.example.weather.data.forecastsdto.ForecastsDto
import com.example.weather.data.infodto.InfoDto
import com.example.weather.domain.entity.WeatherResponseEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponseDto(
    @Json(name = "info")
    override val info: InfoDto,
    @Json(name = "fact")
    override val fact: FactDto,
    @Json(name = "forecasts")
    override val forecasts: List<ForecastsDto>,
) : WeatherResponseEntity
