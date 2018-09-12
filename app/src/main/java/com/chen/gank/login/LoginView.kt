package com.chen.gank.login

import com.chen.common.base.BaseView

interface LoginView : BaseView {

    fun loginSuccess(msg: String)

    fun loginFail(msg: String)
}