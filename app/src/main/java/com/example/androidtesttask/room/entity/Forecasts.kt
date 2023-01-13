package com.example.androidtesttask.room.entity


data class Forecasts(
    var city: String,
    var adcode: String,
    var province: String,
    var reporttime: String,
    var casts: List<Cast>
)
