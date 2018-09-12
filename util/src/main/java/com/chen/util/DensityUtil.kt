package com.chen.util

import android.content.Context

object DensityUtil {

    fun dp2px(context: Context, f: Float): Int = (f * context.resources.displayMetrics.density + 0.5f).toInt()

    fun px2dp(context: Context, f: Float) = (f / context.resources.displayMetrics.density + 0.5f).toInt()

    fun sp2px(context: Context, f: Float) = (f * context.resources.displayMetrics.scaledDensity + 0.5f).toInt()

    fun px2sp(context: Context, f: Float) = (f / context.resources.displayMetrics.scaledDensity + 0.5f).toInt()
}