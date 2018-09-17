package com.chen.util

import android.content.Context

object DisplayUtil {

    @JvmStatic
    fun getWidth(context: Context): Int = context.resources.displayMetrics.widthPixels

    @JvmStatic
    fun getHeight(context: Context): Int = context.resources.displayMetrics.heightPixels

}