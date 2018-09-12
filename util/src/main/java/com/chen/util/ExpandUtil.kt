package com.chen.util

import android.content.Context
import android.widget.Toast

object ExpandUtil {

    fun Context.toastShow(msg: CharSequence?) = msg?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }

    fun Context.toastShow(id: Int) = Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

}