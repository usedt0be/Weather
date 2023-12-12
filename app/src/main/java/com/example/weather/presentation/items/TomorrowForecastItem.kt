package com.example.weather.presentation.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.weather.R
import com.example.weather.data.forecastsdto.ForecastsDto
import com.example.weather.data.forecastsdto.HoursDto
import com.example.weather.data.forecastsdto.parts.PartsDto
import com.example.weather.data.forecastsdto.parts.dayshortdto.DayShortDto
import com.example.weather.data.forecastsdto.parts.nightshortdto.NightShortDto
import com.example.weather.domain.entity.forecasts.ForecastsEntity
import com.example.weather.presentation.translations.Translations
import com.example.weather.ui.theme.DownloadedFonts


@Composable
fun TomorrowForecastItem(forecast: ForecastsEntity) {

    val tomorrowForecast = forecast.parts.day_short

    val icon = Translations.getForecastIcon(tomorrowForecast.condition)

    val fontFamily = DownloadedFonts.Comfortaa.fontFamily

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
        ),

    ) {
        Text(
            text = "Tomorrow",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            fontFamily = DownloadedFonts.Comfortaa.fontFamily,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Condition icon",
                modifier = Modifier
                    .size(150.dp)
                    .padding(start = 8.dp),
                tint = Color.Unspecified
            )


            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 36.dp, end = 42.dp)
                ) {
                    Text(
                        text = "${tomorrowForecast.temp}°",
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontFamily = fontFamily
                    )

                    Text(
                        text = tomorrowForecast.condition,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontFamily = fontFamily
                    )

                }
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier.width(72.dp)
            ) {
                Column {
                    Icon(
                        painter = painterResource(id = R.drawable.wind),
                        contentDescription = "wind_icon",
                        modifier = Modifier
                            .size(36.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = MaterialTheme.colorScheme.tertiaryContainer
                    )

                    Text(
                        text = "${tomorrowForecast.wind_speed} m/s",  //wind speed should be here
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 16.sp
                    )

                }
            }


            Box(
                modifier = Modifier.width(72.dp)
            ) {
                Column {
                    Icon(
                        painter = painterResource(id = R.drawable.humidity),
                        contentDescription = "humidity %",
                        modifier = Modifier
                            .size(36.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = MaterialTheme.colorScheme.tertiaryContainer

                    )
                    Text(
                        text = "${tomorrowForecast.humidity} %", //humidity should be here
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 16.sp
                    )
                }
            }

            Box(
                modifier = Modifier.width(72.dp)
            ) {
                Column {
                    Icon(
                        painter = painterResource(id = R.drawable.sunset),
                        contentDescription = "humidity %",
                        modifier = Modifier
                            .size(36.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = MaterialTheme.colorScheme.tertiaryContainer
                    )
                    Text(
                        text = forecast.sunset,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 16.sp

                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

    }


}


@Preview
@Composable
fun TomorrowForecastItemPreview() {
    TomorrowForecastItem(
        forecast = ForecastsDto(
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
    )
}