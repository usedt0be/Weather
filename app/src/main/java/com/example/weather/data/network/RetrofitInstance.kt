package com.example.weather.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RetrofitInstance @Inject constructor() {
    companion object {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(WeatherApiService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()


        val weatherApi: WeatherApiService =
            retrofit.create(WeatherApiService::class.java)
    }


}