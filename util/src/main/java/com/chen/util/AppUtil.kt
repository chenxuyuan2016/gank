package com.chen.util

import android.content.Context
import org.jetbrains.annotations.NotNull

object AppUtil {

    fun getAppName(context: Context): String = getAppName(context)

    fun getAppName(context: Context, @NotNull packageName: String): String = with(context.packageManager) {
        return context.getString(getPackageInfo(packageName, 0).applicationInfo.labelRes)
    }

    fun getAppPackageName(context: Context): String = context.packageName

    fun getAppVersionCode(context: Context): Int = getAppVersionCode(context, getAppPackageName(context))

    fun getAppVersionCode(context: Context, @NotNull packageName: String): Int = with(context.packageManager) {
        return getPackageInfo(packageName, 0).versionCode
    }


}