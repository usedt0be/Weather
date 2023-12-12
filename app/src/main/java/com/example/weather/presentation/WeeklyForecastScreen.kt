package com.example.weather.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import com.example.weather.presentation.items.ForecastListItem
import com.example.weather.presentation.items.TomorrowForecastItem
import com.example.weather.ui.theme.DownloadedFonts
import com.example.weather.ui.theme.gradientForSecondScreen


@Composable
fun WeeklyForecastScreen(
    forecasts: List<ForecastsEntity>,
    forecastForTomorrow: ForecastsEntity,
    onClickClose: () -> Unit
) {


    val fontFamily = DownloadedFonts.Comfortaa.fontFamily

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientForSecondScreen)
    )
    {
        Row {
            IconButton(onClick = onClickClose) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back to home Screen",
                    tint = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
        Box(modifier = Modifier.padding(top = 10.dp)) {
            TomorrowForecastItem(forecast = forecastForTomorrow)
        }


        Card(
            modifier = Modifier
                .padding(start = 12.dp, end = 8.dp, top = 30.dp, bottom = 10.dp),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.45f)
            ),


        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "Calendar",
                    tint = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.size(20.dp),
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "Weekly forecast",
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontSize = 16.sp,
                    fontFamily = fontFamily
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                items(items = forecasts.subList(fromIndex = 1, toIndex = 7)) { forecasts ->

                    Divider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp)
                    )

                    ForecastListItem(forecasts = forecasts)
                }
            }
        }
    }

}


@Preview
@Composable
fun WeeklyForecastScreenPreview() {
    WeeklyForecastScreen(
        forecasts = List(7) {
            ForecastsDto(
                date = "2023-11-12",
                sunset = "16:45",
                parts = PartsDto(
                    day_short = DayShortDto(
                        temp = 21,
                        temp_min = 15,
                        feels_like = 15,
                        condition = "cloudy",
                        humidity = 84,
                        wind_speed = 2.0
                    ),
                    night_short = NightShortDto(temp_min = 10, condition = "cloudy", humidity = 56)
                ),
                hours = listOf(HoursDto(hour = 13, temp = 15, feels_like = 16, condition = "clear"))
            )
        },
        forecastForTomorrow = ForecastsDto(
            date = "2023-11-12",
            sunset = "16:45",
            parts = PartsDto(
                day_short = DayShortDto(
                    temp = 21,
                    temp_min = 15,
                    feels_like = 15,
                    condition = "cloudy",
                    humidity = 84,
                    wind_speed = 2.0
                ),
                night_short = NightShortDto(temp_min = 10, condition = "cloudy", humidity = 56)
            ),
            hours = listOf(HoursDto(hour = 13, temp = 15, feels_like = 16, condition = "clear")),
        ),
        onClickClose = {}
    )
}