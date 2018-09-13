package com.chen.network.client

import com.google.gson.JsonObject
import io.reactivex.Flowable
import retrofit2.http.*

interface ApiService {

    @GET("{url}")
    @Headers("Content-Type: application/x-www-form-urlencoded; charset=UTF-8")
    @JvmSuppressWildcards
    fun get(@Path(value = "url") url: String, @QueryMap data: Map<String, Any?>): Flowable<JsonObject>

    @GET("{url}")
    @Headers("Content-Type: application/x-www-form-urlencoded; charset=UTF-8")
    fun get(@Path(value = "url") url: String): Flowable<JsonObject>

    @FormUrlEncoded
    @POST("{url}")
    @Headers("Content-Type: application/x-www-form-urlencoded; charset=UTF-8")
    @JvmSuppressWildcards
    fun post(@Path(value = "url") url: String, @QueryMap data: Map<String, Any?>): Flowable<JsonObject>

}