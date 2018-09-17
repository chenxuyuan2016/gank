package com.chen.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

object ImageUtil {

    @JvmStatic
    fun setImageFromNet(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView)
    }

    @JvmStatic
    fun setImageFromFile(context: Context, file: File, imageView: ImageView) {
        Glide.with(context).load(file).into(imageView)
    }

    @JvmStatic
    fun setImageFromBitmap(context: Context, bitmap: Bitmap, imageView: ImageView) {
        Glide.with(context).load(bitmap).into(imageView)
    }

    @JvmStatic
    fun setImageFromDrawable(context: Context, drawable: Drawable, imageView: ImageView) {
        Glide.with(context).load(drawable).into(imageView)
    }

    @JvmStatic
    fun setImageFromId(context: Context, id: Int, imageView: ImageView) {
        Glide.with(context).load(id).into(imageView)
    }

    @JvmStatic
    fun clearImage(context: Context, imageView: ImageView) {
        Glide.with(context).clear(imageView)
    }


}