package com.chen.gank

import com.chen.common.base.BaseApplication

class MyApplication : BaseApplication() {

    companion object {
        // 伴生对象
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}