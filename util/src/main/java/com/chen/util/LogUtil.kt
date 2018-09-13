@file:Suppress("ConstantConditionIf")

package com.chen.util

import android.util.Log

object LogUtil {

    fun e(s: String?) = s?.let {
        if (BuildConfig.IS_SHOW_LOG) {
            Log.e(BuildConfig.LOG_TAG, "\n当前线程：${Thread.currentThread().name}\n$it\n")
        }
    }


    fun w(t: Throwable?) = t?.let {
        if (BuildConfig.IS_SHOW_LOG) {
            Log.w(BuildConfig.LOG_TAG, "\n当前线程：${Thread.currentThread().name}\n$it\n")
        }
    }
}