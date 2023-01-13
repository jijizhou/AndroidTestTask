package com.example.androidtesttask.base

data class BaseModel<T>(
    val forecasts: T,
    val status: Int,
    val info: String,
    val infocode: Int
)