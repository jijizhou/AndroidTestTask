package com.example.androidtesttask.network.service

import com.example.androidtesttask.base.BaseModel
import com.example.androidtesttask.room.entity.Forecasts
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("v3/weather/weatherInfo")
    suspend fun queryWeather(
        @Query("key") key: String,
        @Query("city") city: String,
        @Query("extensions") extensions: String
    ): BaseModel<List<Forecasts>>
}