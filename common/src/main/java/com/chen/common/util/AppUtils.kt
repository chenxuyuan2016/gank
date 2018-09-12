package com.chen.common.util

import android.content.Context
import com.chen.common.manager.AppManager
import org.jetbrains.annotations.NotNull
import java.lang.Exception

object AppUtils {

    fun getAppName(context: Context): String = getAppName(context)

    fun getAppName(context: Context, @NotNull packageName: String): String {
        try {
            val packageInfo = context.packageManager.getPackageInfo(packageName, 0)
            return context.getString(packageInfo.applicationInfo.labelRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun getAppPackageName(context: Context): String = context.packageName

    fun getAppVersionCode(context: Context): Int = getAppVersionCode(context, getAppPackageName(context))

    fun getAppVersionCode(context: Context, @NotNull packageName: String): Int {
        try {
            val packageInfo = context.packageManager.getPackageInfo(packageName, 0)
            return packageInfo.versionCode
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return -1
    }

    fun getWidth(): Int {
        return AppManager.instance.getCurrentActivity().windowManager.defaultDisplay.width
    }

    fun getHeight(): Int {
        return AppManager.instance.getCurrentActivity().windowManager.defaultDisplay.height
    }


}