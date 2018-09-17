package com.chen.util

import android.content.Context
import org.jetbrains.annotations.NotNull

object AppUtil {

    @JvmStatic
    fun getAppName(context: Context): String = getAppName(context)

    @JvmStatic
    fun getAppName(context: Context, @NotNull packageName: String): String = with(context) {
        getString(packageManager.getPackageInfo(packageName, 0).applicationInfo.labelRes)
    }

    @JvmStatic
    fun getAppPackageName(context: Context): String = context.packageName

    @JvmStatic
    fun getAppVersionCode(context: Context): Int = getAppVersionCode(context, getAppPackageName(context))

    @JvmStatic
    fun getAppVersionCode(context: Context, @NotNull packageName: String): Int {
        return context.packageManager.getPackageInfo(packageName, 0).versionCode
    }


}