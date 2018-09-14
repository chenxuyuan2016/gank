package com.chen.network.util

import com.google.gson.Gson
import com.google.gson.JsonObject

object GsonUtil {


    inline fun <reified T> Gson.fromJson(json: JsonObject) = fromJson(json, T::class.java)


    inline fun <reified T> fromJson(json: JsonObject) = Gson().fromJson<T>(json)
}