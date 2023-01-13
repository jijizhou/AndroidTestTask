package com.example.androidtesttask.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtesttask.MainActivity
import com.example.androidtesttask.base.ActivityCollector
import com.example.androidtesttask.base.BaseFragment
import com.example.androidtesttask.base.BaseData
import com.example.androidtesttask.databinding.FragmentForecastBinding
import com.example.androidtesttask.forecast.ForecastAdapter.ForecastItemClickListener

class ForecastFragment : BaseFragment() {

    private var binding: FragmentForecastBinding? = null
    private lateinit var viewModel: ForecastViewModel

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): View {
        binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun initData() {
        viewModel = ForecastViewModel(ForecastsRepository())
    }

    override fun initView() {
        binding?.list?.let { it ->
            it.layoutManager = LinearLayoutManager(it.context, LinearLayoutManager.VERTICAL, false)
            it.adapter = ForecastAdapter(BaseData.cityList, object : ForecastItemClickListener {
                override fun onItemClick(cityCode: String) {
                    val act = this@ForecastFragment.activity as MainActivity
                    act.jumpToDetail(cityCode)
//                    startLoading()
//                    viewModel.getForecasts(cityCode)
//                    setDataStatus(viewModel.forecastsLiveData) {
//                        val casts = it[0].casts
//                        val tips = casts[0].date
//                        this@ForecastFragment.activity.showToast(tips)
//                    }
                }
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ForecastFragment()
    }

    override fun handleBackPressed(): Boolean {
        //处理自己的逻辑
        ActivityCollector.finishAll()
        return true
    }

}
