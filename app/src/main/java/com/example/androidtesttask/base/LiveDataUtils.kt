package com.example.androidtesttask.base

import android.util.Log
import androidx.lifecycle.liveData

private const val TAG = "LiveDataUtils"

fun <T> liveDataModel(block: suspend () -> BaseModel<T>) =
    liveData {
        val result = try {
            val baseModel = block()
            if (baseModel.status == 1) {
                val model = baseModel.forecasts
                Result.success(model)
            } else {
                Log.e(
                    TAG,
                    "fires: response status is ${baseModel.infocode}  msg is ${baseModel.info}"
                )
                Result.failure(RuntimeException(baseModel.info))
            }
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
            Result.failure(e)
        }
        emit(result)
    }

fun <T> liveDataFire(block: suspend () -> Result<T>) =
    liveData {
        val result = try {
            block()
        } catch (e: Exception) {
            Log.e(TAG, "fire $e")
            Result.failure(e)
        }
        emit(result)
    }