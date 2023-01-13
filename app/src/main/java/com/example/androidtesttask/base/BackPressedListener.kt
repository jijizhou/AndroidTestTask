package com.example.androidtesttask.base

/**
 * 监听activity的onBackPress事件
 */
interface BackPressedListener {
    /**
     * @return true代表响应back键点击，false代表不响应
     */
    fun handleBackPressed(): Boolean
}