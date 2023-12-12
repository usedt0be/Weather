package com.example.weather.presentation.translations

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object Translations {
    fun getForecastIcon(condition: String ): Int {
        val theme = DayIconTheme
        return when (condition) {
            in theme.keys -> theme[condition] ?: throw Exception("Forecast Error")
            else -> throw Exception("Forecast Error")
        }
    }

    fun getHourIcon(hour: Int, condition: String): Int {
        // mojno napisat range iz sunset and sunrise...
        val dayTimeRange = 6..21

        val theme = if (dayTimeRange.contains(hour)) DayIconTheme else NightIconTheme

        return when(condition) {
            in theme.keys -> theme[condition] ?: throw Exception("HourlyWeather Error")
            else -> throw Exception("HourlyWeather Error")
        }
    }

    fun getFactIcon(dayTime: String, condition: String): Int {
       val theme = if(dayTime =="d") DayIconTheme else NightIconTheme

        return when (condition) {
            in theme.keys -> theme[condition] ?: throw Exception("Forecast Error")
            else -> throw Exception("Forecast Error")
        }

    }

    fun getDayOfWeek(dateString: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(dateString,formatter)

        return date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
    }




}
