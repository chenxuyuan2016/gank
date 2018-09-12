package com.chen.common.base.presenter

import com.chen.common.base.BaseView

class PresenterDispatch(var providers: PresenterProviders) {

    fun <V : BaseView> onCreate(v: V) = providers.getPresenterStore().getMap().forEach { it.value.onCreate(v) }

    fun onDestroy() = providers.getPresenterStore().clear()

}