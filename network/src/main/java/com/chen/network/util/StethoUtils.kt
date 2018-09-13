package com.chen.network.util

import android.content.Context
import com.chen.network.BuildConfig
import com.facebook.stetho.Stetho

object StethoUtils {

    @Suppress("ConstantConditionIf")
    fun init(context: Context) {
        if (BuildConfig.IS_SHOW_LOG) {
            Stetho.initializeWithDefaults(context)
        }
    }
}