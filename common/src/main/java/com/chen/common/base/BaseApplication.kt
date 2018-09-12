package com.chen.common.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.chen.common.manager.AppManager
import com.chen.common.manager.AppManager.Companion.instance
import com.chen.common.util.AppUtils
import com.orhanobut.logger.Logger

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        registerActivity()
    }

    private fun registerActivity() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                AppManager.instance.addActivity(activity)
            }

            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
                AppManager.instance.removeActivity(activity)
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }
        })
    }
}