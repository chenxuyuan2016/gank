package com.chen.common.base.presenter

import com.chen.common.base.BaseView
import io.reactivex.disposables.CompositeDisposable

interface Presenter {

    fun <V : BaseView> onCreate(v: V)

    fun onDestroy()
}