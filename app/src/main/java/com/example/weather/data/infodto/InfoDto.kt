package com.example.weather.data.infodto

import com.example.weather.domain.entity.info.Info
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoDto(
    @Json(name = "tzinfo")
    override val tzInfo: TzInfoDto
): Info