package com.chen.common.manager

import android.app.Activity
import java.util.*

class AppManager {

    var stack: Stack<Activity> = Stack()

    private object Holder {
        val instance = AppManager()
    }

    companion object {
        val instance: AppManager by lazy { Holder.instance }
    }

    fun addActivity(activity: Activity?) = activity?.let { stack.add(activity) }

    fun removeActivity(activity: Activity?) = activity?.let { stack.remove(activity) }

    fun getCurrentActivity(): Activity = stack.lastElement()

}