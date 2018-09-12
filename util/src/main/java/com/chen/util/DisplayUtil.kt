package com.chen.util

import android.app.Activity

object DisplayUtil {

    fun getWidth(activity: Activity): Int = activity.windowManager.defaultDisplay.width

    fun getHeight(activity: Activity): Int = activity.windowManager.defaultDisplay.height

}