package com.chen.util

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty


class SPUtil<T>(context: Context, private val key: String, val value: T) {

    private val sp: SharedPreferences by lazy { context.getSharedPreferences("cache", Context.MODE_PRIVATE) }


    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = getSharePreferences(key, value)

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putSharePreferences(key, value)


    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    private fun getSharePreferences(key: String, value: T): T = with(sp) {
        return when (value) {
            is Long -> getLong(key, value)
            is String -> getString(key, value)
            is Int -> getInt(key, value)
            is Boolean -> getBoolean(key, value)
            is Float -> getFloat(key, value)
            else -> throw Exception("I have no idea, what type is this.")
        } as T

    }

    private fun putSharePreferences(key: String, value: T) = with(sp.edit()) {
        when (value) {
            is Long -> putLong(key, value)
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            else -> throw IllegalArgumentException("I have no idea, what type is this.")
        }.apply()
    }
}