package com.example.androidtesttask.forecast

import com.example.androidtesttask.base.liveDataModel
import com.example.androidtesttask.base.BaseData
import com.example.androidtesttask.network.AppNetWork

class ForecastsRepository() {

    fun queryForecasts(city: String) = liveDataModel {
        AppNetWork.queryWeather(
            BaseData.amapWebKey,
            city,
            BaseData.extensions_all
        )
    }

}