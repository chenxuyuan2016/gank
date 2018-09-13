package com.chen.network.client

import com.chen.network.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient private constructor(private var readTime: Long,
                                    private var writeTime: Long,
                                    private var connectTime: Long,
                                    private var baseUrl: String) {

    companion object {
        val instance: ApiClient by lazy { Holder.instance }
    }


    private object Holder {
        val instance = ApiClient(5000, 5000, 5000, BuildConfig.BASE_URL)
    }


    fun setReadTimeout(readTime: Long): ApiClient {
        this.readTime = readTime
        return this
    }


    fun setWriteTimeout(writeTime: Long): ApiClient {
        this.writeTime = writeTime
        return this
    }


    fun setConnectTimeout(connectTime: Long): ApiClient {
        this.connectTime = connectTime
        return this
    }


    fun setBaseUrl(baseUrl: String): ApiClient {
        this.baseUrl = baseUrl
        return this
    }


    fun build(baseUrl: String, time: Long): ApiService = setBaseUrl(baseUrl)
            .setConnectTimeout(time)
            .setReadTimeout(time)
            .setWriteTimeout(time)
            .build()


    fun build(): ApiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)


    @Suppress("ConstantConditionIf")
    private fun getClient(): OkHttpClient = with(OkHttpClient.Builder()) {
        this.readTimeout(readTime, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTime, TimeUnit.MILLISECONDS)
                .connectTimeout(connectTime, TimeUnit.MILLISECONDS)
                // No automatic reconnection network
                .retryOnConnectionFailure(false)
        if (BuildConfig.IS_SHOW_LOG) {
            this.addNetworkInterceptor(StethoInterceptor())
        }
        return this.build()
    }


}