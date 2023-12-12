package com.example.weather.data.factdto

import com.example.weather.domain.entity.fact.FactEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FactDto(
    @Json(name = "temp")
    override val temp: Int,
    @Json(name = "feels_like")
    override val feels_like: Int,
    @Json(name = "condition")
    override val condition: String,
    @Json(name = "wind_speed")
    override val wind_speed: Double,
    @Json(name = "humidity")
    override val humidity: Int,
    @Json(name = "cloudness")
    override val cloudness: Double,
    @Json(name = "pressure_mm")
    override val pressure: Int,
    @Json(name = "daytime")
    override val daytime: String
) : FactEntity
