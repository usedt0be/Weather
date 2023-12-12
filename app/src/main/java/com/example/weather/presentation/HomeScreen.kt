package com.example.weather.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.data.factdto.FactDto
import com.example.weather.data.forecastsdto.HoursDto
import com.example.weather.domain.entity.fact.FactEntity
import com.example.weather.domain.entity.forecasts.HoursEntity
import com.example.weather.presentation.items.FactWeatherItem
import com.example.weather.presentation.items.HourlyWeatherCardItem
import com.example.weather.ui.theme.DownloadedFonts
import com.example.weather.ui.theme.gradient


@Composable
fun HomeScreen(
    fact: FactEntity,
    sunset: String,
    hourlyWeather: List<HoursEntity>,
    onClickWeekly: () -> Unit,
    locality: String,
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Column(modifier = Modifier.padding(top = 15.dp)) {

            FactWeatherItem(fact = fact, sunset = sunset, locality = locality)

            Row(
                modifier = Modifier
                    .padding(top = 28.dp, start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween


            ) {
                Text(
                    text = "Today",
                    fontSize = 20.sp,
                    fontFamily = DownloadedFonts.Comfortaa.fontFamily,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Text(
                    text = "Next 7 days",
                    Modifier.clickable { onClickWeekly() },
                    fontSize = 14.sp,
                    fontFamily = DownloadedFonts.Comfortaa.fontFamily,
                    color = MaterialTheme.colorScheme.onTertiary,
                )
            }
        }



        LazyRow(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            items(items = hourlyWeather.take(24)) { hourlyWeather ->
                HourlyWeatherCardItem(hourlyWeather = hourlyWeather)
                Spacer(modifier = Modifier.width(20.dp))

            }

        }

    }

}


@Preview
@Composable

fun MainCardPreview() {
    HomeScreen(fact = FactDto(
        temp = 15,
        feels_like = 17,
        condition = "clear",
        wind_speed = 2.0,
        humidity = 90,
        cloudness = 2.0,
        pressure = 718,
        daytime = "d"
    ), sunset = "17:02", hourlyWeather = List(24) {
        HoursDto(
            hour = 12, temp = 15, feels_like = 17, condition = "overcast"
        )
    }, onClickWeekly = {}, locality = "Novosibirsk")

}