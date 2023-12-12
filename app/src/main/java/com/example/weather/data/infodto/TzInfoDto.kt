package com.example.weather.data.infodto

import com.example.weather.domain.entity.info.TzInfoEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TzInfoDto(
    @Json(name = "offset")
    override val offset: Int,
    @Json(name = "name")
    override val name: String,
    @Json(name = "abbr")
    override val abbr: String
): TzInfoEntity
