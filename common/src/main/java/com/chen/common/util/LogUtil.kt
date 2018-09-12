package com.chen.common.util

import com.chen.common.BuildConfig
import com.orhanobut.logger.Logger

object LogUtil {

    fun e(str: String?) = str?.let {
        if (BuildConfig.IS_SHOW_LOG) Logger.e(it)
    }

    fun d(any: Any?) = any?.let {
        if (BuildConfig.IS_SHOW_LOG) Logger.d(it)
    }
}