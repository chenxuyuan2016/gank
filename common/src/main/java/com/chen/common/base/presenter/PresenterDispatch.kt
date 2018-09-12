package com.chen.common.base.presenter

import com.chen.common.base.BaseView

class PresenterDispatch(providers: PresenterProviders) {
    var map = providers.getPresenterStore().getMap()

    fun <V : BaseView> onCreate(v: V) {
        map.forEach {
            it.value.onCreate(v)
        }
    }


    fun onDestroy() {
        map.forEach {
            it.value.onDestroy()
        }
    }

}