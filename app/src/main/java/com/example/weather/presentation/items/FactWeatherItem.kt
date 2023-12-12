package com.example.weather.presentation.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.data.factdto.FactDto
import com.example.weather.domain.entity.fact.FactEntity
import com.example.weather.presentation.translations.Translations
import com.example.weather.ui.theme.DownloadedFonts


@Composable
fun FactWeatherItem(fact: FactEntity, sunset: String, locality: String) {


    val icon = Translations.getFactIcon(dayTime = fact.daytime, condition = fact.condition)

    val fontFamily = DownloadedFonts.Comfortaa.fontFamily
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = locality,
            fontSize = 24.sp,
            fontFamily = fontFamily,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.SemiBold
        )

    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 26.dp),

        ) {

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = fact.condition, //Condition
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 26.sp,
            fontFamily = fontFamily
        )


        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Weather condition icon",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(150.dp),
        )


        Text(
            text = "${fact.temp}°",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 36.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = fontFamily
        )

        Text(
            text = "feels like ${fact.feels_like}°",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
            fontSize = 18.sp,
            fontFamily = fontFamily,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, end = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(72.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight()

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.wind),
                            contentDescription = "wind_icon",
                            modifier = Modifier
                                .size(36.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = MaterialTheme.colorScheme.secondary
                        )

                        Text(
                            text = "${fact.wind_speed} m/s",  //wind speed should be here
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )

                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(72.dp)
                ) {
                    Column(modifier = Modifier.fillMaxHeight()) {
                        Icon(
                            painter = painterResource(id = R.drawable.humidity),
                            contentDescription = "humidity %",
                            modifier = Modifier
                                .size(36.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = MaterialTheme.colorScheme.secondary

                        )
                        Text(
                            text = "${fact.humidity} %", //humidity should be here
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(72.dp)
                ) {
                    Column(modifier = Modifier.fillMaxHeight()) {
                        Icon(
                            painter = painterResource(id = R.drawable.sunset),
                            contentDescription = "humidity %",
                            modifier = Modifier
                                .size(36.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = sunset,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            color = MaterialTheme.colorScheme.onPrimaryContainer

                        )
                    }
                }
            }

        }


    }

}

@Preview
@Composable
fun FactWeatherItemPreview() {
    FactWeatherItem(
        fact = FactDto(
            temp = 15,
            feels_like = 17,
            condition = "clear",
            wind_speed = 2.0,
            humidity = 90,
            cloudness = 2.0,
            pressure = 718,
            daytime = "d"
        ), sunset = "16:45",
        locality = "Novosibirsk"
    )
}
