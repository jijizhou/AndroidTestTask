package com.example.androidtesttask.utils

import android.content.res.Resources

class SmartUtils {

    //</editor-fold>
    //<editor-fold desc="像素密度">
    private val density = Resources.getSystem().displayMetrics.density

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param dpValue 虚拟像素
     * @return 像素
     */
    fun dp2px(dpValue: Float): Int {
        return (0.5f + dpValue * density).toInt()
    }
}