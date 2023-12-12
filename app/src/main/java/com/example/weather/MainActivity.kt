package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.weather.presentation.LoadingScreen
import com.example.weather.presentation.location.LocationClient
import com.example.weather.presentation.viewmodel.HomeViewModel
import com.example.weather.ui.theme.WeatherTestTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private lateinit var locationClient: LocationClient
    
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            locationClient = LocationClient(context = this, homeViewModel = homeViewModel)

            WeatherTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary
                ) {
                    LoadingScreen(homeViewModel = homeViewModel)
                }
            }
        }
    }
}














