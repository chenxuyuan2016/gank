package com.chen.util

import android.content.Context

object DisplayUtil {

    fun getWidth(context: Context): Int = context.resources.displayMetrics.widthPixels

    fun getHeight(context: Context): Int = context.resources.displayMetrics.heightPixels

}