package com.example.androidtesttask

import android.view.View
import androidx.fragment.app.commit
import com.example.androidtesttask.base.BaseActivity
import com.example.androidtesttask.databinding.ActivityMainBinding
import com.example.androidtesttask.forecast.ForecastDetailFragment
import com.example.androidtesttask.forecast.ForecastFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun getLayoutView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        supportFragmentManager.commit {
            replace(R.id.fragment_container,ForecastFragment.newInstance(),"Forecast")
            setReorderingAllowed(true)
            addToBackStack("Forecast")
        }
    }

    fun jumpToDetail(cityCode: String) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, ForecastDetailFragment.newInstance(cityCode),"ForecastDetail")
            setReorderingAllowed(true)
            addToBackStack("ForecastDetail")
        }
    }
}