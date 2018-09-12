package com.chen.gank

import com.chen.common.annotation.CreatePresenter
import com.chen.common.annotation.PresenterVariable
import com.chen.common.base.BaseActivity
import com.chen.common.util.ExpandUtil.toastShow
import com.chen.gank.login.LoginPresenter
import com.chen.gank.login.LoginView
import com.chen.gank.register.RegisterPresenter

@CreatePresenter(
        kClass = [
            RegisterPresenter::class,
            LoginPresenter::class
        ]
)
class MainActivity : BaseActivity(), LoginView {

    @PresenterVariable
    private var mainPresenter: MainPresenter? = null

    @PresenterVariable
    private var registerPresenter: RegisterPresenter? = null

    @PresenterVariable
    private var loginPresenter: LoginPresenter? = null

    override fun layoutId(): Int = R.layout.activity_main

    override fun initData() {
        // It will not report wrong
        mainPresenter?.test()
        registerPresenter?.register()
        loginPresenter?.login()
    }

    override fun loginSuccess(msg: String) {
        // do something
    }

    override fun loginFail(msg: String) {
        // do something
    }

    override fun toast(msg: String) = toastShow(msg)
}
