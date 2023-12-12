package com.example.weather.data.network

import com.example.weather.data.response.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApiService {

    companion object {
        const val BASE_URL = "https://api.weather.yandex.ru/v2/"
    }

    @Headers(
        "Accept: application/json",
        "Content-type: application/json",
        "X-Yandex-API-Key: 63748acf-57ad-4e1f-997b-aad2b6918b8b"
    )
    @GET("forecast?")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("limit") limit: Int = 7,
        @Query("hours") hours: Boolean = true
    ): WeatherResponseDto
}