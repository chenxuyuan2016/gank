package com.chen.common.base.presenter

import com.chen.common.base.BaseView

class PresenterManager(var providers: PresenterProviders) {

    fun <V : BaseView> onPresenterCreate(v: V) = providers.onPresenterCreate(v)

    fun onPresenterDestroy() = providers.onPresenterDestroy()

}