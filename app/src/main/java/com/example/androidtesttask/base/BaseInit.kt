package com.example.androidtesttask.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 在Activity或Fragment中初始化需要的函数。
 */
interface BaseInit {

    fun initData()

    fun initView()

}

interface BaseActivityInit : BaseInit {

    fun getLayoutView(): View

}

interface BaseFragmentInit : BaseInit {

    fun getLayoutView(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): View

    /**
     * @return true代表响应back键点击，false代表不响应
     */
    fun handleBackPressed(): Boolean
}