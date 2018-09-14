package com.chen.network.bean

import com.google.gson.annotations.SerializedName
import java.util.*


class TodayModel {

    @SerializedName("Android")
    var android: Array<TodayResult>? = null

    @SerializedName("iOS")
    var ios: Array<TodayResult>? = null

    @SerializedName("休息视频")
    var video: Array<TodayResult>? = null

    @SerializedName("前端")
    var web: Array<TodayResult>? = null

    @SerializedName("拓展资源")
    var res: Array<TodayResult>? = null

    @SerializedName("瞎推荐")
    var recommend: Array<TodayResult>? = null

    @SerializedName("福利")
    var welfare: Array<TodayResult>? = null


    class TodayResult {
        var _id: String? = null
        var createdAt: String? = null
        var desc: String? = null
        var images: Array<String>? = null
        var publishedAt: String? = null
        var source: String? = null
        var type: String? = null
        var url: String? = null
        var used: Boolean? = null
        var who: String? = null

        override fun toString(): String {
            return "TodayResult(_id=$_id, createdAt=$createdAt, desc=$desc, images=${Arrays.toString(images)}, publishedAt=$publishedAt, source=$source, type=$type, url=$url, used=$used, who=$who)"
        }
    }

    override fun toString(): String {
        return "TodayModel(android=${Arrays.toString(android)}, ios=${Arrays.toString(ios)}, video=${Arrays.toString(video)}, web=${Arrays.toString(web)}, res=${Arrays.toString(res)}, recommend=${Arrays.toString(recommend)}, welfare=${Arrays.toString(welfare)})"
    }


}