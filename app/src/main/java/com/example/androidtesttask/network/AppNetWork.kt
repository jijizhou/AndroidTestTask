package com.example.androidtesttask.network

import com.example.androidtesttask.network.service.WeatherService

object AppNetWork {

    private val weatherService = ServiceCreator.create(WeatherService::class.java)

    suspend fun queryWeather(key: String, city: String, extensions: String) =
        weatherService.queryWeather(key, city, extensions)

}