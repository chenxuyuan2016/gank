package com.chen.gank

import com.chen.common.base.BaseApplication
import com.chen.network.util.StethoUtils

class MyApplication : BaseApplication() {

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        StethoUtils.init(this)
    }
}