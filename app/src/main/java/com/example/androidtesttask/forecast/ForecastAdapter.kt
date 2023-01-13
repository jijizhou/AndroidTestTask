package com.example.androidtesttask.forecast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidtesttask.base.BaseRecyclerAdapter
import com.example.androidtesttask.bean.CityCode
import com.example.androidtesttask.databinding.AdapterForecastBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class ForecastAdapter(
    private val cityList: List<CityCode>,
    private val itemClickListener: ForecastItemClickListener
) : BaseRecyclerAdapter<AdapterForecastBinding>(), CoroutineScope by MainScope() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerHolder<AdapterForecastBinding> {
        val binding =
            AdapterForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseRecyclerHolder(binding)
    }

    override fun onBaseBindViewHolder(position: Int, binding: AdapterForecastBinding) {
        val data = cityList[position]
        binding.apply {
            binding.cityName.text = data.name
            binding.cityItem.setOnClickListener(View.OnClickListener {
                itemClickListener.onItemClick(data.code)
            })
        }
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    interface ForecastItemClickListener{
        fun onItemClick(cityCode: String)
    }
}