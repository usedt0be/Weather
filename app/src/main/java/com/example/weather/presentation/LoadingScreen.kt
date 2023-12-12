package com.example.weather.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.weather.R
import com.example.weather.presentation.viewmodel.HomeViewModel
import com.example.weather.presentation.viewmodel.STATE

enum class Screens {
    Home, Weekly
}

@Composable
fun LoadingScreen(homeViewModel: HomeViewModel) {

    val navController = rememberNavController()

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        when (homeViewModel.state) {
            STATE.FAILED -> ErrorSection()
            STATE.LOADING -> LoadingSection()
            STATE.SUCCESS -> {

                val forecasts = homeViewModel.weatherResult.collectAsState().value?.forecasts

                val fact = homeViewModel.weatherResult.collectAsState().value?.fact

                val hourlyWeather = homeViewModel.hourlyWeatherResult.collectAsState().value

                val forecastForTomorrow = forecasts?.get(1)

                val sunset = forecasts?.get(0)?.sunset

                val locality = homeViewModel.address.collectAsState().value


                NavHost(
                    navController = navController,
                    startDestination = Screens.Home.name,
                    builder = {
                        composable(Screens.Home.name) {
                            if (fact != null && sunset != null) {
                                    HomeScreen(fact = fact,
                                        sunset = sunset,
                                        hourlyWeather = hourlyWeather,
                                        onClickWeekly = { navController.navigate(Screens.Weekly.name) },
                                        locality = locality
                                    )
                            }
                        }
                        composable(Screens.Weekly.name) {
                            if (forecasts != null && forecastForTomorrow != null) {
                                WeeklyForecastScreen(forecasts = forecasts,
                                    forecastForTomorrow = forecastForTomorrow,
                                    onClickClose = { navController.navigate(Screens.Home.name) })

                            }
                        }
                    })

            }
        }
    }
}


@Composable
fun LoadingSection() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.circle_progress_indicator))

        val progress by animateLottieCompositionAsState(composition = composition, speed = 2.0f)
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.padding(all = 170.dp)
        )
    }
}

@Composable
fun ErrorSection() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Error", color = Color.Red)
    }

}



@Preview
@Composable
fun LoadingSectionPreview() {
    LoadingSection()
}





