package com.chen.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

object ImageUtil {

    fun setImageFromNet(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView)
    }

    fun setImageFromFile(context: Context, file: File, imageView: ImageView) {
        Glide.with(context).load(file).into(imageView)
    }

    fun setImageFromBitmap(context: Context, bitmap: Bitmap, imageView: ImageView) {
        Glide.with(context).load(bitmap).into(imageView)
    }

    fun setImageFromDrawable(context: Context, drawable: Drawable, imageView: ImageView) {
        Glide.with(context).load(drawable).into(imageView)
    }

    fun setImageFromId(context: Context, id: Int, imageView: ImageView) {
        Glide.with(context).load(id).into(imageView)
    }

    fun clearImage(context: Context, imageView: ImageView) {
        Glide.with(context).clear(imageView)
    }


}