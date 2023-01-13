package com.example.androidtesttask.forecast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ForecastViewModel(forecastsRepository: ForecastsRepository) :
    ViewModel() {

    private val cityCodeLiveData = MutableLiveData<String>()

    val forecastsLiveData = Transformations.switchMap(cityCodeLiveData) { city ->
        forecastsRepository.queryForecasts(city)
    }

    fun getForecasts(cityCode: String) {
        cityCodeLiveData.value = cityCode
    }

}