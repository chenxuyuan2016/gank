package com.chen.gank

import com.chen.common.annotation.CreatePresenter
import com.chen.common.annotation.PresenterVariable
import com.chen.common.base.BaseActivity
import com.chen.gank.login.LoginPresenter
import com.chen.gank.login.LoginView
import com.chen.gank.register.RegisterPresenter
import com.chen.gank.login.RegisterView
import com.chen.util.ExpandUtil.toastShow

@CreatePresenter(
        kClass = [
            RegisterPresenter::class,
            LoginPresenter::class
        ]
)
class MainActivity : BaseActivity(), LoginView,RegisterView {

    @PresenterVariable
    private var mainPresenter: MainPresenter? = null

    @PresenterVariable
    private var registerPresenter: RegisterPresenter? = null

    @PresenterVariable
    private var loginPresenter: LoginPresenter? = null

    override fun layoutId(): Int = R.layout.activity_main

    override fun initData() {
        // It will not report wrong, because if it is empty, it does not perform.
        // mainPresenter?.test()
        registerPresenter?.register()
    }

    override fun toast(msg: String) = toastShow(msg)

    override fun registerSuccess() {
        loginPresenter?.login()
    }
}
