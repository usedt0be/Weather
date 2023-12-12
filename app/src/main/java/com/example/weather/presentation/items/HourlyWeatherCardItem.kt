package com.example.weather.presentation.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.data.forecastsdto.HoursDto
import com.example.weather.domain.entity.forecasts.HoursEntity
import com.example.weather.presentation.translations.Translations
import com.example.weather.ui.theme.DownloadedFonts


@Composable
fun HourlyWeatherCardItem(hourlyWeather: HoursEntity) {
    val fontFamily = DownloadedFonts.Comfortaa.fontFamily

    val icon = Translations.getHourIcon(
        condition = hourlyWeather.condition, hour = hourlyWeather.hour

    )


    Column(
        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = String.format("%02d", hourlyWeather.hour),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 20.sp,
            fontFamily = fontFamily
        )

        Icon(
            painter = painterResource(id = icon),
            contentDescription = "weather_icon",
            tint = Color.Unspecified,
            modifier = Modifier.size(52.dp)
        )

        Text(
            text = "${hourlyWeather.temp}°",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 20.sp,
            fontFamily = fontFamily
        )

    }

}


@Preview
@Composable
fun HourlyWeatherCardItemPreview() {
    HourlyWeatherCardItem(
        hourlyWeather = HoursDto(
            hour = 12, temp = 15, feels_like = 17, condition = "overcast"
        ),
    )
}