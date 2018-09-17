package com.chen.util

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.ViewGroup

class StatusBarUtil private constructor(var activity: Activity, var color: Int) {


    fun a() = with(activity) {
        val statusBarHeight = getStatusBarHeight()
        val decorView = window.decorView as ViewGroup
        // setup window paddingTop is statusBarHeight
        decorView.findViewById<ViewGroup>(android.R.id.content)
                .setPadding(0, statusBarHeight, 0, 0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        } else {
            decorView.addView(View(activity)
                    .apply {
                        setBackgroundColor(color)
                    }, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight))
        }
    }

    private fun getStatusBarHeight(): Int = with(activity.resources) {
        val resourcesId = getIdentifier("status_bar_height", "dimen", "android")
        if (resourcesId > 0) {
            return getDimensionPixelSize(resourcesId)
        }
        return 0
    }

}