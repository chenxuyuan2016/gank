package com.chen.common.extend

import android.content.Context
import android.widget.Toast

object Extend {

    fun Context.toastShow(msg: CharSequence?) = msg?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}