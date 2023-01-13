package com.example.androidtesttask.base

import com.example.androidtesttask.bean.CityCode

class BaseData {

    companion object {
        const val amapWebKey = "6858c5d486a72f4b206232f036861c2e"
        const val extensions_all = "all"
        const val extensions_base = "base"

        val shangHai = CityCode("上海", "310000")

        val cityList = listOf(
            CityCode("北京", "110000"),
            CityCode("上海", "310000"),
            CityCode("广州", "440100"),
            CityCode("深圳", "440300"),
            CityCode("苏州", "320500"),
            CityCode("沈阳", "210100")
        )
    }

}