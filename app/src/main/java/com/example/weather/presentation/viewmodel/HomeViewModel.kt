package com.example.weather.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.repository.WeatherResponseRepositoryImpl
import com.example.weather.domain.entity.WeatherResponseEntity
import com.example.weather.domain.entity.forecasts.HoursEntity
import com.example.weather.domain.entity.forecasts.parts.PartsEntity
import com.example.weather.domain.usecases.GetForecastUseCase
import com.example.weather.domain.usecases.GetWeatherResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class STATE {
    LOADING,
    SUCCESS,
    FAILED
}


@HiltViewModel
class HomeViewModel @Inject constructor(
    repositoryImpl: WeatherResponseRepositoryImpl
    ) : ViewModel() {

    var state by mutableStateOf(STATE.LOADING)

    private var useCase: GetWeatherResponseUseCase = GetWeatherResponseUseCase(repositoryImpl)

    private var useCaseForecast: GetForecastUseCase = GetForecastUseCase(repositoryImpl)


    private var _weatherResult = MutableStateFlow<WeatherResponseEntity?>(null)
    val weatherResult: StateFlow<WeatherResponseEntity?>
        get() = _weatherResult.asStateFlow()


    private var _hourlyWeather = MutableStateFlow<List<HoursEntity>>(emptyList())
    val hourlyWeatherResult: StateFlow<List<HoursEntity>>
        get() = _hourlyWeather.asStateFlow()


    private var _parts = MutableStateFlow<List<PartsEntity>>(emptyList())
    val parts: StateFlow<List<PartsEntity>>
        get() = _parts.asStateFlow()



    private var _address: MutableStateFlow<String> = MutableStateFlow("-")
    val address : StateFlow<String>
        get() = _address.asStateFlow()


    fun getAddress(city: String) {
        _address.value  = city
    }


    fun getWeatherResultByLocation(lat: Double, lon: Double) {

        viewModelScope.launch(Dispatchers.IO) {
            state = STATE.LOADING
            try {
                _weatherResult.value = useCase.execute(lat, lon)
                state = STATE.SUCCESS
            } catch (e: Exception) {
                state = STATE.FAILED
            }
        }
    }

    fun getHourlyWeatherByLocation(lat: Double, lon: Double) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                state = STATE.LOADING

                val forecasts = useCaseForecast.execute(lat, lon)
                val hourlyWeather = mutableListOf<HoursEntity>()

                val parts = mutableListOf<PartsEntity>()

                for (forecast in forecasts) {
                    hourlyWeather.addAll(forecast.hours.filterNotNull())
                    _hourlyWeather.value = hourlyWeather

                    parts.addAll(listOf(forecast.parts))
                    _parts.value = parts

                }
                state = STATE.SUCCESS
            }

        } catch (e: Exception) {
            state = STATE.FAILED
            error(message = "cant get hourly weather")
        }

    }


}