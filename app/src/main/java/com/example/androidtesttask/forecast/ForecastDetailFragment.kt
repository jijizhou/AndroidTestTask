package com.example.androidtesttask.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidtesttask.base.BaseFragment
import com.example.androidtesttask.databinding.FragmentForecastDetailBinding
import com.example.androidtesttask.room.entity.Forecasts

class ForecastDetailFragment(private val cityCode: String) : BaseFragment() {

    private var binding: FragmentForecastDetailBinding? = null
    private lateinit var viewModel: ForecastViewModel

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): View {
        binding = FragmentForecastDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun initData() {
        viewModel = ForecastViewModel(ForecastsRepository())
        startLoading()
        viewModel.getForecasts(cityCode)
        setDataStatus(viewModel.forecastsLiveData) {
            refreshData(it[0])
        }
    }

    fun refreshData(forecasts: Forecasts) {
        val cast = forecasts.casts[1]
        binding?.let { it ->
            it.tvProvince.text= forecasts.province
            it.tvCity.text = forecasts.city
            it.tvReporttime.text = forecasts.reporttime
            it.tvDate.text = cast.date
            it.tvWeek.text = cast.week
            it.tvDayweather.text = cast.dayweather
            it.tvNightweather.text = cast.nightweather
            it.tvDaytemp.text = cast.daytemp
            it.tvNighttemp.text = cast.nighttemp
            it.tvDaywind.text = cast.daywind
            it.tvNightwind.text = cast.nightwind
            it.tvDaypower.text = cast.daypower
            it.tvNightpower.text = cast.nightpower
        }
    }
    override fun initView() {

    }

    companion object {
        @JvmStatic
        fun newInstance(cityCode: String) = ForecastDetailFragment(cityCode)
    }

}
