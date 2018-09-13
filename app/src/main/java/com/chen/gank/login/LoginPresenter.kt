package com.chen.gank.login

import com.chen.common.base.BasePresenter
import com.chen.gank.MyApplication
import com.chen.util.LogUtil
import com.chen.util.SPUtil

class LoginPresenter : BasePresenter<LoginView>() {
    private var username by SPUtil(MyApplication.instance, "username", "")
    private var pwd by SPUtil(MyApplication.instance, "pwd", "")

    fun login() {
        if ("kconn" == username && "123456" == pwd) {
            LogUtil.e("Success")
            mView?.toast("Success")
        }
    }

}