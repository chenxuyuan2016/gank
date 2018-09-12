package com.chen.gank.login

import com.chen.common.base.BasePresenter

class LoginPresenter : BasePresenter<LoginView>() {


    fun login() = mView?.toast("Success")

}