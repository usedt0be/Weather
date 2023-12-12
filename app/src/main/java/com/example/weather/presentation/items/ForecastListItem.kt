package com.example.weather.presentation.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.data.forecastsdto.ForecastsDto
import com.example.weather.data.forecastsdto.HoursDto
import com.example.weather.data.forecastsdto.parts.PartsDto
import com.example.weather.data.forecastsdto.parts.dayshortdto.DayShortDto
import com.example.weather.data.forecastsdto.parts.nightshortdto.NightShortDto
import com.example.weather.domain.entity.forecasts.ForecastsEntity
import com.example.weather.presentation.translations.Translations
import com.example.weather.ui.theme.DownloadedFonts


@Composable
fun ForecastListItem(forecasts: ForecastsEntity) {

    val condition = forecasts.parts.day_short.condition

    val icon: Int = Translations.getForecastIcon(condition)

    val dayOfWeek = forecasts.date?.let { Translations.getDayOfWeek(dateString = it) }

    val fontFamily = DownloadedFonts.Comfortaa.fontFamily


    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {


        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(56.dp)
            ) {
                Text(
                    text = "$dayOfWeek", //day of week should be here
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontFamily = fontFamily
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                painter = painterResource(id = icon),
                tint = Color.Unspecified,
                contentDescription = "weather_icon", // weather icon should be here
                modifier = Modifier
                    .size(46.dp)
                    .alignByBaseline()

            )
            Spacer(modifier = Modifier.width(8.dp))

        }

        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Text(
                    text = "${forecasts.parts.day_short.temp}°", // max_temp should be here
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = fontFamily
                )

            }


            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "${forecasts.parts.night_short.temp_min}°", // min_temp should be here
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = fontFamily
                )
            }
        }
    }

}


@Composable
@Preview

fun ForecastListItemPreview() {
    val forecasts = ForecastsDto(
        date = "2023-11-12", sunset = "16:45", parts = PartsDto(
            day_short = DayShortDto(
                temp = 21,
                temp_min = 15,
                feels_like = 15,
                condition = "cloudy",
                humidity = 84,
                wind_speed = 2.0
            ), night_short = NightShortDto(temp_min = 10, condition = "cloudy", humidity = 56)
        ), hours = listOf(HoursDto(hour = 13, temp = 15, feels_like = 16, condition = "clear"))
    )
    ForecastListItem(forecasts = forecasts)
}

